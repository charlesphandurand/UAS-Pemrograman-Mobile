package com.example.uas_mobile.ui.gameweb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_mobile.databinding.ListGamewebViewItemBinding
import com.example.uas_mobile.network.GameWeb

class GameWebListAdapter(val clickListener: GameWebListener) :
    ListAdapter<GameWeb, GameWebListAdapter.GameWebViewHolder>(DiffCallback) {

    class GameWebViewHolder(
        var binding: ListGamewebViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: GameWebListener, gameweb: GameWeb){
            binding.gameweb = gameweb
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<GameWeb>(){

        override fun areItemsTheSame(oldItem: GameWeb, newItem: GameWeb): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: GameWeb, newItem: GameWeb): Boolean {
            return oldItem.thumbnail == newItem.thumbnail && oldItem.short_description == newItem.short_description
                    && oldItem.genre == newItem.genre && oldItem.platform == newItem.platform
                    && oldItem.developer == newItem.developer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameWebViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GameWebViewHolder(
            ListGamewebViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GameWebViewHolder, position: Int){
        val gameweb = getItem(position)
        holder.bind(clickListener, gameweb)
    }

}

class GameWebListener(val clickListener: (gameweb: GameWeb) -> Unit) {
    fun onClick(gameweb: GameWeb) = clickListener(gameweb)
}