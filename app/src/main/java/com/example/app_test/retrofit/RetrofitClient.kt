package com.example.app_test.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

var okHttpClient = OkHttpClient().newBuilder()
    .connectTimeout(30, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .writeTimeout(30, TimeUnit.SECONDS)
    .build()

// 싱글턴
object RetrofitClient {
    private var retrofitClient : Retrofit? =null
//    private lateinit var retrofitClient : Retrofit
    private const val URL = "https://localhost/192.168.74.1:7000/"

    val sRetrofit = initRetrofit()
    private const val WEATHER_URL = "http://172.30.1.11:7000"



    private fun initRetrofit() : Retrofit =
        Builder()
            .baseUrl(WEATHER_URL)
            .client(okHttpClient)// 앞에 바뀌지 않는 url
            .addConverterFactory(GsonConverterFactory.create()) // json을 java class로 만들어주는 factory
            .build()

//    var client : OkHttpClient = Builder()
//        .connectTimeout(1, TimeUnit.MINUTES)
//        .readTimeout(30, TimeUnit.SECONDS)
//        .writeTimeout(15, TimeUnit.SECONDS)
//        .build()



//    // 레트로핏 클라이언트 가져오기기
//   fun getClient(baseUrl: String) : Retrofit? {
//        Log.d(TAG, "RetrofitClient - getClient() called")
//
//        // okhttp 인스턴스 생성
//        val client = OkHttpClient.Builder()
//
//        // 로깅 인터셉터 추가
//        var loggingInterceptor = HttpLoggingInterceptor(object: HttpLoggingInterceptor.Logger {
//            override fun log(message: String) {
//                Log.d(TAG, "RetrofitClient - log() called/ message : ${message}")
//
//                when {
//                    message.isJsonObject() ->
//                        Log.d(TAG, JSONObject(message).toString(4))
//                    message.isJsonArray() ->
//                        Log.d(TAG, JSONObject(message).toString(4))
//                    else -> {
//                        try {
//                            Log.d(TAG, JSONObject(message).toString(4))
//                        } catch (e: Exception) {
//                            Log.d(TAG, message)
//                        }
//                    }
//                }
//            }
//        })
//
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//        // 위에서 설정한 로깅 인터셉터를 okhttp 클라이언트에 추가
//        client.addInterceptor(loggingInterceptor)
//
//        // 기본 파라미터 추가
//        val baseParameterInterceptor : Interceptor = (object : Interceptor{
//            override fun intercept(chain: Interceptor.Chain): Response {
//                TODO("Not yet implemented")
//                val originalRequest = chain.request()
//
//                // 쿼리 파라미터 추가하기 -> ?client_id=asdfadsf..어저구
//                val addedUrl = originalRequest.url.newBuilder().addQueryParameter("client_id", API.CLIENT_ID).build()
//                val finalRequest = originalRequest.newBuilder()
//                    .url(addedUrl)
//                    .method(originalRequest.method, originalRequest.body)
//                    .build()
//
//                return chain.proceed(finalRequest)
//            }
//        })
//
//        // 위에서 설정한 기본 파라미터 인터셉터를 okhttp 클라이언트에 추가
//        client.addInterceptor(baseParameterInterceptor)
//
//        // 커넥션 타임아웃
//        client.connectTimeout(10, TimeUnit.SECONDS)
//        client.readTimeout(10, TimeUnit.SECONDS)
//        client.writeTimeout(10, TimeUnit.SECONDS)
//        client.retryOnConnectionFailure(true)
//
//
//        if (retrofitClient == null) {
//            retrofitClient = Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//
//                // 위에서 설정한 클라이언트로 레트로핏 클라이언트 생성
//                .client(client.build())
//                .build()
//        }
//        return retrofitClient
//    }

}

