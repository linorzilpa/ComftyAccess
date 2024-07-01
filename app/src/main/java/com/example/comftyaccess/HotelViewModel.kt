import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import org.json.JSONObject
import java.net.URL

class HotelViewModel : ViewModel() {
    private var hotels: List<Hotel> = listOf()

    init {
        trustAllCertificates()
    }

    fun loadHotels(onResult: (List<Hotel>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {  // Switch to IO dispatcher
            try {
                hotels = fetchHotels()
                withContext(Dispatchers.Main) {  // Switch back to Main Thread for UI operations
                    onResult(hotels)  // Pass the loaded hotels to the callback
                }
            } catch (e: Exception) {
                Log.e("HotelViewModel", "Error fetching hotels: ${e.message}", e)
            }
        }
    }

    private fun trustAllCertificates() {
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun getAcceptedIssuers(): Array<X509Certificate>? = null
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}
            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}
        })

        try {
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.socketFactory)
            HttpsURLConnection.setDefaultHostnameVerifier(HostnameVerifier { _, _ -> true })
        } catch (e: Exception) {
            Log.e("HotelViewModel", "Failed to set TrustManager", e)
        }
    }

    private suspend fun fetchHotels(): List<Hotel> {
        val url = URL("https://test.api.amadeus.com/v1/reference-data/locations/hotels/by-city?cityCode=PAR&radius=5&radiusUnit=KM&hotelSource=ALL")
        val accessToken = "xekkIrM20Bxvhzmp1XPBOIrGOOPH"  // Use securely fetched token
        val connection = url.openConnection() as HttpsURLConnection
        connection.apply {
            requestMethod = "GET"
            setRequestProperty("Authorization", "Bearer $accessToken")
            connect()
        }

        val responseCode = connection.responseCode
        Log.d("HotelViewModel", "HTTP response code: $responseCode")
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return connection.inputStream.bufferedReader().use { reader ->
                val response = reader.readText()
                Log.d("HotelViewModel", "Raw JSON response: $response")
                parseHotels(response)
            }
        } else {
            Log.e("HotelViewModel", "Failed to fetch hotels: Response code $responseCode, ${connection.responseMessage}")
            throw Exception("Failed to fetch hotels: Response code $responseCode, ${connection.responseMessage}")
        }
    }

    private fun parseHotels(jsonStr: String): List<Hotel> {
        val jsonObject = JSONObject(jsonStr)
        val dataArray = jsonObject.getJSONArray("data")
        return List(dataArray.length()) { i ->
            val hotelObj = dataArray.getJSONObject(i)
            val hotelName = hotelObj.getString("name")
            val geoCode = hotelObj.getJSONObject("geoCode")
            val latitude = geoCode.getDouble("latitude")
            val longitude = geoCode.getDouble("longitude")
            Log.d("HotelViewModel", "Parsed hotel: $hotelName at ($latitude, $longitude)")
            Hotel(hotelName, latitude, longitude)
        }
    }
}

data class Hotel(val name: String, val latitude: Double, val longitude: Double)