package com.example.uas_mobile.ui.gamepc

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
import com.example.uas_mobile.databinding.FragmentGamepcListBinding

class GamePCListFragment: Fragment() {
    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGamepcListBinding.inflate(inflater)
        viewModel.getGamePCList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = GamePCListAdapter(GamePCListener { gamepc ->
            viewModel.onGamePCClicked(gamepc)
            findNavController()
                .navigate(R.id.action_gamePCListFragment_to_gamePCDetailFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "List Game PC"

        return binding.root
    }
}