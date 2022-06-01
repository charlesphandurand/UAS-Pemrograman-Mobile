package com.example.uas_mobile.ui.gamepc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_mobile.network.GamePC
import com.example.uas_mobile.network.GamePCApi
import kotlinx.coroutines.launch

enum class GamePCApiStatus { LOADING, ERROR, DONE }

class GamePCViewModel : ViewModel(){
    private val _statuspc = MutableLiveData<GamePCApiStatus>()
    val statuspc: LiveData<GamePCApiStatus> = _statuspc

    private val _gamespc = MutableLiveData<List<GamePC>>()
    val gamespc: LiveData<List<GamePC>> = _gamespc

    private val _gamepc = MutableLiveData<GamePC>()
    val gamepc: LiveData<GamePC> = _gamepc

    fun getGamePCList() {
        viewModelScope.launch {
            _statuspc.value = GamePCApiStatus.LOADING
            try {
                _gamespc.value = GamePCApi.retrofitServiceApi.getGamesPC()
                _statuspc.value = GamePCApiStatus.DONE
            } catch (e: Exception) {
                _gamespc.value = listOf()
                _statuspc.value = GamePCApiStatus.ERROR
            }
        }
    }

    fun onGameClicked(gamepc: GamePC) {
        _gamepc.value = gamepc
    }

}