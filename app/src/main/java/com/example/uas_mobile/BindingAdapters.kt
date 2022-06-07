package com.example.uas_mobile

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.uas_mobile.network.GameNews
import com.example.uas_mobile.network.GamePC
import com.example.uas_mobile.network.GameWeb
import com.example.uas_mobile.ui.gamenews.GameNewsListAdapter
import com.example.uas_mobile.ui.gamepc.GamePCListAdapter
import com.example.uas_mobile.ui.gameweb.GameWebListAdapter

@BindingAdapter("listData")
fun bindRecyclerViewGamePC(recyclerView: RecyclerView, data: List<GamePC>?){
    val adapter = recyclerView.adapter as GamePCListAdapter
    adapter.submitList(data)
}

@BindingAdapter("listData")
fun bindRecyclerViewGameWeb(recyclerView: RecyclerView, data: List<GameWeb>?){
    val adapter = recyclerView.adapter as GameWebListAdapter
    adapter.submitList(data)
}

@BindingAdapter("listData")
fun bindRecyclerViewGameNews(recyclerView: RecyclerView, data: List<GameNews>?){
    val adapter = recyclerView.adapter as GameNewsListAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: GameApiStatus?) {
    when(status) {
        GameApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        GameApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        GameApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}