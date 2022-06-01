package com.example.uas_mobile.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.mmobomb.com/api1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface GameWebServiceApi{
    @GET("games?platform=browser")
    suspend fun getGamesWeb() : List<GameWeb>
}

object GameWebApi{
    val retrofitServiceApi : GameWebServiceApi by lazy {
        retrofit.create(GameWebServiceApi::class.java)
    }
}