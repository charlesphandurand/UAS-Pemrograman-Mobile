package com.example.uas_mobile.ui.gameweb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.uas_mobile.databinding.FragmentGamewebDetailBinding

class GameWebDetailFragment : Fragment() {
    private val viewModelWeb: GameWebViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGamewebDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModelWeb = viewModelWeb

        (activity as AppCompatActivity).supportActionBar?.title = "Detail Game"

        return binding.root
    }
}