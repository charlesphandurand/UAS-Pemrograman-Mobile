package com.example.uas_mobile.ui.gamepc

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.uas_mobile.R
import com.example.uas_mobile.network.GamePC

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<GamePC>?){
    val adapter = recyclerView.adapter as GamePCListAdapter
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
fun bindStatus(statusImageView: ImageView, status: GamePCApiStatus?) {
    when(status) {
        GamePCApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        GamePCApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        GamePCApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}