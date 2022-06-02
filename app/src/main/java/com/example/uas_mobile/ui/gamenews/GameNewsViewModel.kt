package com.example.uas_mobile.ui.gamenews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_mobile.network.GameNews
import com.example.uas_mobile.network.GameNewsApi
import kotlinx.coroutines.launch

enum class GameNewsApiStatus { LOADING, ERROR, DONE }

class GameNewsViewModel : ViewModel(){
    private val _statusnews = MutableLiveData<GameNewsApiStatus>()
    val statusnews: LiveData<GameNewsApiStatus> = _statusnews

    private val _gamesnews = MutableLiveData<List<GameNews>>()
    val gamesnews: LiveData<List<GameNews>> = _gamesnews

    private val _gamenews = MutableLiveData<GameNews>()
    val gamenews: LiveData<GameNews> = _gamenews

    fun getGameNewsList() {
        viewModelScope.launch {
            _statusnews.value = GameNewsApiStatus.LOADING
            try {
                _gamesnews.value = GameNewsApi.retrofitServiceApi.getGamesNews()
                _statusnews.value = GameNewsApiStatus.DONE
            } catch (e: Exception) {
                _gamesnews.value = listOf()
                _statusnews.value = GameNewsApiStatus.ERROR
            }
        }
    }

    fun onGameClicked(gamenews: GameNews) {
        _gamenews.value = gamenews
    }

}