package com.example.app_test.retrofit

import com.example.app_test.retrofit.utils.API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofit {


    // https://www.unsplash.com/search/photos/?query="cat"     (searchTerm = "cat")
    @GET(API.SEARCH_PHOTOS)
    fun searchPhotos(@Query("query") searchTerm: String): Call<JsonElement>?
//    abstract fun searchPhotos( seachTerm: String, searchTerm: String) : Call<JsonElement>?

    @GET(API.SEARCH_USERS)
    fun searchUsers(@Query("query") seachTerm: String): Call<JsonElement>

    @GET("/users")
    fun getDustData(): Call<JsonElement>

}