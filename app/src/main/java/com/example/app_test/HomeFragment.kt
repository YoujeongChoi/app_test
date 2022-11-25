package com.example.app_test

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.media.metrics.LogSessionId
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.app_test.databinding.FragmentHomeBinding
import com.example.app_test.model.DustResponse
import com.example.app_test.retrofit.RetrofitClient
import com.example.app_test.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var test : String
    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        getWeatherData()
        return binding.root
    }

    private fun getWeatherData() {
        Log.d(TAG, "hello - onResponse() called")

        Toast.makeText(this.context,"hi", Toast.LENGTH_SHORT).show()

        val weatherDataInterface = RetrofitClient.sRetrofit.create(RetrofitInterface::class.java)
        weatherDataInterface.getWeatherData("createdz").enqueue(object :retrofit2.Callback<DustResponse>{
            //                @SuppressLint("SetTextI18n")
            override fun onResponse(
                // response 가 제대로 불러왔을 때
                call: Call<DustResponse>,
                response: Response<DustResponse>

            ) {
                if(response.isSuccessful) {
                    val result = response.body() as DustResponse
                    Log.d(TAG, "${result}")
                    binding.homeTimeTv.text = result.month.toString() + "월 " + result.day.toString() + "일 " + result.hour.toString() + "시 " + result.min.toString() +  "분 "
                    binding.homeFinedustData.text = result.PM_10.toString()
                    binding.homeDustData.text = result.PM_2_5.toString()
                } else {

                    Log.d(TAG, "통신실패 - onResponse() called")
                }
            }

            override fun onFailure(call: Call<DustResponse>, t: Throwable, ) {         // 서버통신 실패했을 때

                Log.d(TAG, "$t")
                Log.d(TAG, "통신실패..!")
            }

        })
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            HomeFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }

        fun newInstance(title: String) = HomeFragment().apply {
            arguments = Bundle().apply {
                putString("fragment_title", title)
            }
        }
    }
}