package com.example.uas_mobile.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uas_mobile.R

class AboutViewModel() : ViewModel() {
    private val _text = MutableLiveData<String>()
    val text: LiveData<String> get() = _text

    fun text(){
        _text.value = R.string.nama.toString()
        _text.value = R.string.nim.toString()
        _text.value = R.string.email.toString()
        _text.value = R.string.github.toString()
        _text.value = R.string.moto.toString()
    }
}