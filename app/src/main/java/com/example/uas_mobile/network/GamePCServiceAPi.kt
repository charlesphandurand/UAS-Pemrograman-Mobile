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

interface GamePCServiceApi{
    @GET("games?platform=pc")
    suspend fun getGamesPC() : List<GamePC>
}

object GamePCApi{
    val retrofitServiceApi : GamePCServiceApi by lazy {
        retrofit.create(GamePCServiceApi::class.java)
    }
}