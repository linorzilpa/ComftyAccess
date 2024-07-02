package com.example.comftyaccess

import Hotel
import HotelViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.comftyaccess.databinding.FragmentMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap
    private lateinit var binding: FragmentMapBinding
    private val hotelViewModel: HotelViewModel by viewModels()  // Correctly initialize the ViewModel
    private val allReviewsViewModel: AllReviewsViewModel by viewModels()

    override fun onStart() {
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Map"
        super.onStart()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        Log.d("MapFragment", "View created")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
        Log.d("MapFragment", "Map Async Initialized")
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        Log.d("MapFragment", "Map is ready")
        allReviewsViewModel.data.observe(viewLifecycleOwner) { reviews ->
            hotelViewModel.loadHotels { hotels ->
                val reviewedHotels = hotels.filter { hotel ->
                    reviews.any { review -> review.hotelName == hotel.name }
                }
                addHotelsToMap(reviewedHotels)
            }
        }
    }

    private fun addHotelsToMap(hotels: List<Hotel>) {
        hotels.forEach { hotel ->
            val location = LatLng(hotel.latitude, hotel.longitude)
            googleMap.addMarker(MarkerOptions().position(location).title(hotel.name))
        }
        if (hotels.isNotEmpty()) {
            val firstHotel = hotels.first()
            val location = LatLng(firstHotel.latitude, firstHotel.longitude)
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10.0f))
        }
        setupMapListeners(googleMap)
    }

    private fun setupMapListeners(map: GoogleMap) {
        map.setOnMarkerClickListener { marker ->
            Log.d("MapFragment", "Marker '${marker.title}' clicked")
            Toast.makeText(context, "Hotel: ${marker.title}", Toast.LENGTH_LONG).show()
            val action = MapFragmentDirections.actionMapFragmentToFilteredReviewsFragment(
                "Rather not to mention",
                "Rather not to mention",
                "Rather not to mention",
                "Rather not to mention",
                marker.title
            )
            findNavController().navigate(action)
            true
        }
    }
}