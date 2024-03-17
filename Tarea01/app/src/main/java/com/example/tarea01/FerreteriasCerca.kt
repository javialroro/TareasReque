package com.example.tarea01
import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.android.volley.BuildConfig
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

data class Place(val name: String, val latitude: Double, val longitude: Double)
class FerreteriasCerca : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ferreterias_cerca)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        Places.initialize(this, "AIzaSyBr48ySTq8McOJ03k6DRfmc1v7RgxlqQOI")
        val placesClient: PlacesClient = Places.createClient(this)
        createMapFragment()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE)
        } else {
            // Permission has already been granted
            getLastLocation()
        }

    }

    private fun createMapFragment() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }

    fun cameraZoom(latLng: LatLng) {
        runOnUiThread {
            map.moveCamera(
                com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(
                    latLng,
                    13f
                )
            )
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                // Got last known location. In some rare situations this can be null.
                location?.let {
                    // Use the latitude and longitude as needed
                    val latitude = it.latitude
                    val longitude = it.longitude
                    val position = LatLng(latitude, longitude)
                    CoroutineScope(Dispatchers.IO).launch {
                        makeApiCall(position)
                        cameraZoom(position)
                    }
                }
            }
    }

    private suspend fun makeApiCall(latLng: LatLng) {
        val placesArray = ArrayList<Place>()
        val apiKey = getString(R.string.google_maps_key)
        val request = Request.Builder().url("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=${latLng.latitude},${latLng.longitude}&radius=1500&type=hardware_store&key=$apiKey")
            .build()

        val response = OkHttpClient().newCall(request).execute().body?.string()
        val jsonObject = JSONObject(response) // This will make the json below as an object for you

        // You can access all the attributes, nested ones using JSONArray and JSONObject here
        CoroutineScope(Dispatchers.Main).launch {
            val resultsArray = jsonObject.getJSONArray("results")
            for (i in 0 until resultsArray.length()) {
                val placeObject = resultsArray.getJSONObject(i)
                val name = placeObject.getString("name")
                val locationObject = placeObject.getJSONObject("geometry").getJSONObject("location")
                val latitude = locationObject.getDouble("lat")
                val longitude = locationObject.getDouble("lng")
                val position = LatLng(latitude, longitude)

                map.addMarker(MarkerOptions().position(position).title(name))

            }

        }
    }



    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Permission granted
                    getLastLocation()
                } else {
                    // Permission denied
                    // Handle this case
                }
                return
            }
        }
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 100
    }






}