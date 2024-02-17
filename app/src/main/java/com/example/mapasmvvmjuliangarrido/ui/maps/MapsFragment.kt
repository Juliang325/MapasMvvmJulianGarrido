package com.example.mapasmvvmjuliangarrido.ui.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.mapasmvvmjuliangarrido.R
import com.example.mapasmvvmjuliangarrido.databinding.FragmentHomeBinding
import com.example.mapasmvvmjuliangarrido.ui.home.HomeViewModel

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {
    var latitude = 0.0
    var longitude = 0.0

    private val callback = OnMapReadyCallback { googleMap ->

        val sydney = LatLng(latitude, longitude)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val sharedViewModel =
            ViewModelProvider(this).get(MapsViewModel::class.java)

        sharedViewModel.latitude.observe(viewLifecycleOwner) {
            latitude = it
        }
        sharedViewModel.longitude.observe(viewLifecycleOwner) {
            longitude = it
        }
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}