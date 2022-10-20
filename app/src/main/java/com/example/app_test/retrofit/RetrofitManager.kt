package com.example.app_test.retrofit

import android.content.ContentValues.TAG
import android.util.Log
import com.example.app_test.retrofit.utils.API
import com.example.app_test.retrofit.utils.RESPONSE_STATE
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {
    companion object {
        val instance = RetrofitManager()
    }

    // http콜 만들기
    // 레트로핏 인터페이스 가져오기
    private val iRetrofit: IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)

    // 사진 검색 api 호출
    fun searchPhotos(searchTerm: String?, completion: (RESPONSE_STATE, String) -> Unit) {

        val term = searchTerm.let{
            it
        }?: ""          // searchTerm이 비어있다면 ""을 넣어라, 비어있지않으면 it 반환

       val call = iRetrofit?.searchPhotos(searchTerm = term).let {
           it
       }?: return

//        val call = iRetrofit?.searchPhotos(searchTerm = term) ?: return

        call.enqueue(object: retrofit2.Callback<JsonElement>{
            // 응답 성공시
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager - () called / response: ${response.raw()}")
                completion(RESPONSE_STATE.OKAY,response.raw().toString())
            }

            // 응답 실패시
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - onFailure() called / t: $t")
                completion(RESPONSE_STATE.FAIL,t.toString())
            }

        })
    }
}