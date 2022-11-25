package com.example.app_test.retrofit

import com.example.app_test.model.DustResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("/user")        // 어떤 http 메소드인지 정의
    fun getWeatherData (@Query("sort") sort : String): Call<DustResponse>

    /*
    @GET()
    Call<PostResult> getPosts(@Path("post") String post)
    */

}