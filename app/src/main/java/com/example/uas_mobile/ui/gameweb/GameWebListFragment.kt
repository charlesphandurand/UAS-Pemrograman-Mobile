package com.example.uas_mobile.ui.gameweb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uas_mobile.GameViewModel
import com.example.uas_mobile.R
import com.example.uas_mobile.databinding.FragmentGamewebListBinding

class GameWebListFragment: Fragment() {
    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGamewebListBinding.inflate(inflater)
        viewModel.getGameWebList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = GameWebListAdapter(GameWebListener { gameweb ->
            viewModel.onGameWebClicked(gameweb)
            findNavController()
                .navigate(R.id.action_gameWebListFragment_to_gameWebDetailFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "List Game Web"

        return binding.root
    }
}