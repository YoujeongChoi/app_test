package com.example.app_test

import android.os.Bundle
import android.text.method.Touch.scrollTo
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app_test.databinding.FragmentFineDustMapBinding
import com.example.app_test.databinding.FragmentHomeBinding
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FineDustMapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FineDustMapFragment : Fragment() , OnMapReadyCallback{
    // TODO: Rename and change types of parameters

    private lateinit var mView: MapView
    private lateinit var mBinding: FragmentFineDustMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        mBinding = FragmentFineDustMapBinding.inflate(inflater, container, false)
//
//        return mBinding.root

        var rootView = inflater.inflate(R.layout.fragment_fine_dust_map, container, false  )

        mView = rootView.findViewById(R.id.mv_contactUs_gMap) as MapView
        mView.onCreate(savedInstanceState)
        mView.getMapAsync(this)

//        val mapFragment = supportFragmentManager
//            .findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this

       return rootView




    }

    override fun onMapReady(googleMap: GoogleMap) {
        val seoul = LatLng(37.3676587, 126.5965)
//        val myLocation = LatLng(37.3676587, 126.5965)
        val cameraUpdate = CameraUpdate.scrollTo(LatLng(37.3676587, 126.5965))
//        googleMap.moveCamera(cameraUpdate)
        googleMap.moveCamera(cameraUpdate)
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(10f))

        val marker = MarkerOptions()
            .position(seoul)
            .title("Kookmin univ.")
            .snippet("국민대학교")
        googleMap?.addMarker(marker)
    }

    override fun onStart() {
        super.onStart()
        mView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mView.onStop()
    }

    override fun onResume() {
        super.onResume()
        mView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mView.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mView.onLowMemory()
    }

    override fun onDestroy() {
        mView.onDestroy()
        super.onDestroy()
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FineDustMapFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FineDustMapFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

