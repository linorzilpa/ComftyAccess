package com.example.comftyaccess
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.comftyaccess.databinding.FragmentMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.util.Log

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap
    private lateinit var binding: FragmentMapBinding

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
        // Set a location and adjust zoom level to see larger area
        val location = LatLng(-25.2744, 133.7751) // Coordinates for Australia
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 4.0f))
        googleMap.addMarker(MarkerOptions().position(location).title("Marker in Australia"))
        setupMapListeners(googleMap)
    }

    private fun setupMapListeners(map: GoogleMap) {
        map.setOnMarkerClickListener { marker ->
            Log.d("MapFragment", "Marker '${marker.title}' clicked")
            Toast.makeText(context, "Marker: ${marker.title}", Toast.LENGTH_SHORT).show()
            true
        }
        map.setOnMapClickListener { latLng ->
            Log.d("MapFragment", "Map clicked at: $latLng")
            map.clear() // Clear previous markers
            map.addMarker(MarkerOptions().position(latLng).title("New Marker"))
            map.animateCamera(CameraUpdateFactory.newLatLng(latLng))
        }
    }
}