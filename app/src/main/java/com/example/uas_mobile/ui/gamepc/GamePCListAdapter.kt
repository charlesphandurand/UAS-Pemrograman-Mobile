package com.example.uas_mobile.ui.gamepc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_mobile.databinding.ListGamepcViewItemBinding
import com.example.uas_mobile.network.GamePC

class GamePCListAdapter(val clickListener: GamePCListener) :
    ListAdapter<GamePC, GamePCListAdapter.GamePCViewHolder>(DiffCallback) {

    class GamePCViewHolder(
        var binding: ListGamepcViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: GamePCListener, gamepc: GamePC){
            binding.gamepc = gamepc
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<GamePC>(){

        override fun areItemsTheSame(oldItem: GamePC, newItem: GamePC): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: GamePC, newItem: GamePC): Boolean {
            return oldItem.thumbnail == newItem.thumbnail && oldItem.short_description == newItem.short_description
                    && oldItem.genre == newItem.genre && oldItem.platform == newItem.platform
                    && oldItem.developer == newItem.developer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamePCViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GamePCViewHolder(
            ListGamepcViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GamePCViewHolder, position: Int){
        val gamepc = getItem(position)
        holder.bind(clickListener, gamepc)
    }

}

class GamePCListener(val clickListener: (gamepc: GamePC) -> Unit) {
    fun onClick(gamepc: GamePC) = clickListener(gamepc)
}