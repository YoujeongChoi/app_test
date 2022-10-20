package com.example.app_test.retrofit

import android.content.ContentValues.TAG
import android.util.Log
import com.example.app_test.retrofit.utils.isJsonArray
import com.example.app_test.retrofit.utils.isJsonObject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 싱글턴
object RetrofitClient {
    private var retrofitClient : Retrofit? =null
//    private lateinit var retrofitClient : Retrofit
    private const val URL = "https://localhost:7000/"

    // 레트로핏 클라이언트 가져오기기
   fun getClient(baseUrl: String) : Retrofit? {
        Log.d(TAG, "RetrofitClient - getClient() called")
        
        // okhttp 인스턴스 생성
        val client = OkHttpClient.Builder()

        // 로깅 인터셉터 추가
        var loggingInterceptor = HttpLoggingInterceptor(object: HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d(TAG, "RetrofitClient - log() called/ message : ${message}")

                when {
                    message.isJsonObject() ->

                    message.isJsonArray() ->
                        Log.d(TAG, JSONObject(message).toString(4))
                    else -> {
                        try {
                            Log.d(TAG, JSONObject(message).toString(4))
                        } catch (e: Exception) {
                            Log.d(TAG, message)
                        }
                    }
                }
            }
        })
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)

        // 위에서 설정한 로깅 인터셉터를 okhttp 클라이언트에 추가
        client.addInterceptor(loggingInterceptor)
 
        // 기본 파라미터 추가

        if (retrofitClient == null) {
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofitClient
    }

}