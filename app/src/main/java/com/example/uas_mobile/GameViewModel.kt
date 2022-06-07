package com.example.uas_mobile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_mobile.network.*
import com.example.uas_mobile.repository.GameRepository
import kotlinx.coroutines.launch

enum class GameApiStatus { LOADING, ERROR, DONE }

class GameViewModel : ViewModel(){

    private val gameRepository = GameRepository()

    //STATUS
    private val _status = MutableLiveData<GameApiStatus>()
    val status: LiveData<GameApiStatus> = _status

    //GAME PC
    private val _gamespc = MutableLiveData<List<GamePC>>()
    val gamespc: LiveData<List<GamePC>> = _gamespc

    private val _gamepc = MutableLiveData<GamePC>()
    val gamepc: LiveData<GamePC> = _gamepc

    fun getGamePCList() {
        viewModelScope.launch {
            _status.value = GameApiStatus.LOADING
            try {
                _gamespc.value = gameRepository.getGamesPC()
                _status.value = GameApiStatus.DONE
            } catch (e: Exception) {
                _gamespc.value = listOf()
                _status.value = GameApiStatus.ERROR
            }
        }
    }

    fun onGamePCClicked(gamepc: GamePC) {
        _gamepc.value = gamepc
    }

    //GAME WEB
    private val _gamesweb = MutableLiveData<List<GameWeb>>()
    val gamesweb: LiveData<List<GameWeb>> = _gamesweb

    private val _gameweb = MutableLiveData<GameWeb>()
    val gameweb: LiveData<GameWeb> = _gameweb

    fun getGameWebList() {
        viewModelScope.launch {
            _status.value = GameApiStatus.LOADING
            try {
                _gamesweb.value = gameRepository.getGamesWeb()
                _status.value = GameApiStatus.DONE
            } catch (e: Exception) {
                _gamesweb.value = listOf()
                _status.value = GameApiStatus.ERROR
            }
        }
    }

    fun onGameWebClicked(gameweb: GameWeb) {
        _gameweb.value = gameweb
    }

    //GAME NEWS
    private val _gamesnews = MutableLiveData<List<GameNews>>()
    val gamesnews: LiveData<List<GameNews>> = _gamesnews

    private val _gamenews = MutableLiveData<GameNews>()
    val gamenews: LiveData<GameNews> = _gamenews

    fun getGameNewsList() {
        viewModelScope.launch {
            _status.value = GameApiStatus.LOADING
            try {
                _gamesnews.value = gameRepository.getGamesNews()
                _status.value = GameApiStatus.DONE
            } catch (e: Exception) {
                _gamesnews.value = listOf()
                _status.value = GameApiStatus.ERROR
            }
        }
    }

    fun onGameNewsClicked(gamenews: GameNews) {
        _gamenews.value = gamenews
    }
}