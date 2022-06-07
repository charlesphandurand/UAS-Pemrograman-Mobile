package com.example.uas_mobile.repository

import com.example.uas_mobile.network.GameApiService
import com.example.uas_mobile.network.GameNews
import com.example.uas_mobile.network.GamePC
import com.example.uas_mobile.network.GameWeb

class GameRepository() {

    suspend fun getGamesPC(): List<GamePC>{
        return GameApiService.retrofitServiceApi.getGamesPC()
    }

    suspend fun getGamesWeb() : List<GameWeb>{
        return GameApiService.retrofitServiceApi.getGamesWeb()
    }

    suspend fun getGamesNews() : List<GameNews>{
        return GameApiService.retrofitServiceApi.getGamesNews()
    }

}
