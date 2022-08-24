package com.hassan.codewars.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.hassan.codewars.databinding.FragmentChallengeDetailBinding

class ChallengeDetailFragment : Fragment() {
    private lateinit var binding: FragmentChallengeDetailBinding
    private val args: ChallengeDetailFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChallengeDetailBinding.inflate(inflater, container, false)
        binding.user.text = args.challenge.name


        return binding.root
    }
}