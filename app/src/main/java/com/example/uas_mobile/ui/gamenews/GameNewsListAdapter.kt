package com.example.uas_mobile.ui.gamenews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_mobile.databinding.ListGamenewsViewItemBinding
import com.example.uas_mobile.network.GameNews

class GameNewsListAdapter(val clickListener: GameNewsListener) :
    ListAdapter<GameNews, GameNewsListAdapter.GameNewsViewHolder>(DiffCallback) {

    class GameNewsViewHolder(
        var binding: ListGamenewsViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: GameNewsListener, gamenews: GameNews){
            binding.gamenews = gamenews
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<GameNews>(){

        override fun areItemsTheSame(oldItem: GameNews, newItem: GameNews): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: GameNews, newItem: GameNews): Boolean {
            return oldItem.short_description == newItem.short_description && oldItem.main_image == newItem.main_image
                    && oldItem.article_content == newItem.article_content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameNewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GameNewsViewHolder(
            ListGamenewsViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GameNewsViewHolder, position: Int){
        val gamenews = getItem(position)
        holder.bind(clickListener, gamenews)
    }

}

class GameNewsListener(val clickListener: (gamenews: GameNews) -> Unit) {
    fun onClick(gamenews: GameNews) = clickListener(gamenews)
}