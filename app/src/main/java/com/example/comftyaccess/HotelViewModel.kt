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

/**
 * ViewModel for fetching hotel data from the Amadeus API.
 * This ViewModel handles network requests asynchronously, bypasses SSL certificate validation,
 * and updates UI components - Hotel name drop down spinner.
 */
class HotelViewModel : ViewModel() {
    // List to hold the hotels data fetched from the API
    private var hotels: List<Hotel> = listOf()


    /**
     * Fetch hotels asynchronously and handle the result on the UI thread.
     * @param onResult Callback to pass the fetched hotels back to the UI thread.
     */
    fun loadHotels(onResult: (List<Hotel>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {  // Perform network operations on IO dispatcher
            try {
                hotels = fetchHotels()
                withContext(Dispatchers.Main) {  // Switch back to Main Thread to update UI
                    onResult(hotels)
                }
            } catch (e: Exception) {
                Log.e("HotelViewModel", "Error fetching hotels: ${e.message}", e)
            }
        }
    }


    /**
     * Fetch hotels from the API.
     * @return List of Hotel objects parsed from the API response.
     */
    private suspend fun fetchHotels(): List<Hotel> {
        val url = URL("https://test.api.amadeus.com/v1/reference-data/locations/hotels/by-city?cityCode=NYC&radius=5&radiusUnit=KM&hotelSource=ALL")
        val accessToken = "YcQYcC1VyIIpb8YGSDU53cGRqy5w"  // Placeholder for securely fetched token
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

    /**
     * Parse JSON response into a list of Hotel objects.
     * @param jsonStr JSON string to parse.
     * @return List of Hotel objects.
     */
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