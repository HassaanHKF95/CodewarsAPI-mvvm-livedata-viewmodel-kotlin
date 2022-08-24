package com.hassan.codewars.presentation.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hassan.codewars.R

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hassan.codewars.databinding.FragmentChallengeListBinding
import com.hassan.codewars.presentation.adapters.ChallengeListAdapter
import com.hassan.codewars.presentation.models.viewModels.ChallengesListViewModel


class ChallengeListFragment : Fragment() {
    private lateinit var binding: FragmentChallengeListBinding
    lateinit var viewModel: ChallengesListViewModel
    val adapter = ChallengeListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChallengeListBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(ChallengesListViewModel::class.java)


        binding.challengeRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.challengeRecycler.adapter = adapter
        viewModel.init()
        viewModel.getchallengesModelLiveData()?.observe(viewLifecycleOwner, {
            if (it != null)
                adapter.setChallengeList(it.data)
        })

        viewModel.callChallengesAPI("0")

        binding.user.setOnClickListener {
            findNavController().navigate(R.id.list_to_detail)
        }


        return binding.root
    }
}