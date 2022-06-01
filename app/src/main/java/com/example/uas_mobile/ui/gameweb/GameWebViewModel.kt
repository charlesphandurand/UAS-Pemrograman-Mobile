package com.example.uas_mobile.ui.gameweb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_mobile.network.GamePC
import com.example.uas_mobile.network.GamePCApi
import com.example.uas_mobile.network.GameWeb
import com.example.uas_mobile.network.GameWebApi
import kotlinx.coroutines.launch

enum class GameWebApiStatus { LOADING, ERROR, DONE }

class GameWebViewModel : ViewModel(){
    private val _statusweb = MutableLiveData<GameWebApiStatus>()
    val statusweb: LiveData<GameWebApiStatus> = _statusweb

    private val _gamesweb = MutableLiveData<List<GameWeb>>()
    val gamesweb: LiveData<List<GameWeb>> = _gamesweb

    private val _gameweb = MutableLiveData<GameWeb>()
    val gameweb: LiveData<GameWeb> = _gameweb

    fun getGameWebList() {
        viewModelScope.launch {
            _statusweb.value = GameWebApiStatus.LOADING
            try {
                _gamesweb.value = GameWebApi.retrofitServiceApi.getGamesWeb()
                _statusweb.value = GameWebApiStatus.DONE
            } catch (e: Exception) {
                _gamesweb.value = listOf()
                _statusweb.value = GameWebApiStatus.ERROR
            }
        }
    }

    fun onGameClicked(gameweb: GameWeb) {
        _gameweb.value = gameweb
    }

}