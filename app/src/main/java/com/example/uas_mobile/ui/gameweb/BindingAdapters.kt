package com.example.uas_mobile.ui.gameweb

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.uas_mobile.R
import com.example.uas_mobile.network.GameWeb

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<GameWeb>?){
    val adapter = recyclerView.adapter as GameWebListAdapter
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
fun bindStatus(statusImageView: ImageView, status: GameWebApiStatus?) {
    when(status) {
        GameWebApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        GameWebApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        GameWebApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}