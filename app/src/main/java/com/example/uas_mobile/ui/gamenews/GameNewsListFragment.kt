package com.example.uas_mobile.ui.gamenews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uas_mobile.R
import com.example.uas_mobile.databinding.FragmentGamenewsListBinding

class GameNewsListFragment: Fragment() {
    private val viewModelNews: GameNewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGamenewsListBinding.inflate(inflater)
        viewModelNews.getGameNewsList()
        binding.lifecycleOwner = this
        binding.viewModelNews = viewModelNews
        binding.recyclerView.adapter = GameNewsListAdapter(GameNewsListener { gamenews ->
            viewModelNews.onGameClicked(gamenews)
            findNavController()
                .navigate(R.id.action_gameNewsListFragment_to_gameNewsDetailFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "List News"

        return binding.root
    }
}