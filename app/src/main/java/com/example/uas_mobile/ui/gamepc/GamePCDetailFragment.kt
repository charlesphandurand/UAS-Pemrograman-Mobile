package com.example.uas_mobile.ui.gamepc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.uas_mobile.databinding.FragmentGamepcDetailBinding

class GamePCDetailFragment : Fragment() {
    private val viewModelPC: GamePCViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGamepcDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModelPC = viewModelPC

        (activity as AppCompatActivity).supportActionBar?.title = "Detail Game"

        return binding.root
    }
}