package com.example.app_test

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.app_test.databinding.FragmentFineDustMapBinding
import com.example.app_test.model.DustResponse
import com.example.app_test.retrofit.RetrofitClient
import com.example.app_test.retrofit.RetrofitInterface
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import retrofit2.Call
import retrofit2.Response

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

    lateinit var mView: MapView
    lateinit var binding: FragmentFineDustMapBinding
    var pm10 = 0
    var pm2_5 = 0

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
        binding = FragmentFineDustMapBinding.inflate(inflater, container, false)

//        var rootView = inflater.inflate(R.layout.fragment_fine_dust_map, container, false  )
        var rootView = binding

//        mView = rootView.findViewById(R.id.mv_contactUs_gMap) as MapView
        mView = binding.mvContactUsGMap as MapView
        mView.onCreate(savedInstanceState)
        mView.getMapAsync(this)

//        val mapFragment = supportFragmentManager
//            .findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this
        getWeatherData()


        binding.mapStarIb.setOnClickListener{
            binding.mapStarIb.setImageResource(R.drawable.star_icon_yellow)

//            activity?.let{
//                val intent = Intent(context, BookmarkFragment::class.java)
//                intent.putExtra("pm2_5", pm2_5)
//                intent.putExtra("pm10", pm10)
//                intent.putExtra("address", binding.mapAddressTv.text)
//                startActivity(intent)
//            }

        }
        return binding.root
    }

    private fun getWeatherData() {
        Log.d(ContentValues.TAG, "hello - onResponse() called")

        Toast.makeText(this.context,"hi", Toast.LENGTH_SHORT).show()

        val weatherDataInterface = RetrofitClient.sRetrofit.create(RetrofitInterface::class.java)
        weatherDataInterface.getWeatherData("creates").enqueue(object :retrofit2.Callback<DustResponse>{
            //                @SuppressLint("SetTextI18n")
            override fun onResponse(
                // response 가 제대로 불러왔을 때
                call: Call<DustResponse>,
                response: Response<DustResponse>

            ) {
                if(response.isSuccessful) {
                    val result = response.body() as DustResponse
                    binding.mapDustData.text = result.PM_10.toString()
                    pm10 = result.PM_10
                    binding.mapFineDustData.text = result.PM_2_5.toString()
                    pm2_5 = result.PM_2_5
                } else {

                    Log.d(ContentValues.TAG, "통신실패 - onResponse() called")
                }
            }

            override fun onFailure(call: Call<DustResponse>, t: Throwable) {         // 서버통신 실패했을 때

                Log.d(ContentValues.TAG, "$t")
                Log.d(ContentValues.TAG, "통신실패..!")
            }

        })
    }


    override fun onMapReady(googleMap: GoogleMap) {
        val seoul = LatLng(37.54547408, 126.9650744)

        val marker = MarkerOptions()
            .position(seoul)
            .title("Kookmin univ.")
            .snippet("국민대학교")
        googleMap?.addMarker(marker)

        val myLocation = LatLng(37.3676587, 126.5965)

//        val myLocation = LatLng(37.3676587, 126.5965)
//        val cameraUpdate = CameraUpdate.scrollTo(LatLng(37.3676587, 126.5965))
//        googleMap.moveCamera(cameraUpdate)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul, 15f))
//        googleMap.moveCamera(CameraUpdateFactory.zoomBy(3f))


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

