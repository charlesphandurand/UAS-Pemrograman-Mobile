package com.example.uas_mobile.ui.gamenews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.uas_mobile.databinding.FragmentGamenewsDetailBinding

class GameNewsDetailFragment : Fragment() {
    private val viewModelNews: GameNewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGamenewsDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModelNews = viewModelNews

        (activity as AppCompatActivity).supportActionBar?.title = "News Detail"

        return binding.root
    }
}