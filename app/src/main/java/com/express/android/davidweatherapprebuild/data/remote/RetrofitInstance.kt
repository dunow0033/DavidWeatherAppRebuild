package com.express.android.davidweatherapprebuild.data.remote

import com.express.android.davidweatherapprebuild.utils.Constants
import com.express.android.davidweatherapprebuild.utils.Constants.Companion.TIMEOUT
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

//object RetrofitInstance {
//
//    private fun providesOkHttpClient(): OkHttpClient {
//        val httpLoggingInterceptor =
//            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
//                .setLevel(HttpLoggingInterceptor.Level.BODY)
//
//        return OkHttpClient.Builder().connectTimeout(TIMEOUT, TimeUnit.SECONDS)
//            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
//            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
//            .addInterceptor(httpLoggingInterceptor)
//            .build()
//    }
//
//    fun providesRetrofit() : Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
//            .client(providesOkHttpClient())
//            .build()
//    }
//}



object RetrofitInstance {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    private fun providesOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                .setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder().connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(providesOkHttpClient())
            .build()
    }

    val weatherService: WeatherService by lazy {
        providesRetrofit().create(WeatherService::class.java)
    }
}