package ru.marten.teacherapplication.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientOkHttp {

    //https://wizard-world-api.herokuapp.com/swagger/index.html
    private const val BASE_URL = "https://wizard-world-api.herokuapp.com"

    val harryPotterApi: HarryPotterApi = getRetrofit(BASE_URL).create(HarryPotterApi::class.java)

    private fun getRetrofit(baseUrl: String): Retrofit {
        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}