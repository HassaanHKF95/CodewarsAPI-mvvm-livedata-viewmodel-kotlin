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
import androidx.recyclerview.widget.RecyclerView
import com.hassan.codewars.data.helper.PaginationScrollListener
import com.hassan.codewars.databinding.FragmentChallengeListBinding
import com.hassan.codewars.presentation.adapters.ChallengeListAdapter
import com.hassan.codewars.presentation.models.viewModels.ChallengesListViewModel


class ChallengeListFragment : Fragment() {
    private lateinit var binding: FragmentChallengeListBinding
    lateinit var viewModel: ChallengesListViewModel
    val adapter = ChallengeListAdapter()

    var isLastPage: Boolean = false
    var isLoading: Boolean = false
    var page = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChallengeListBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(ChallengesListViewModel::class.java)

        val layoutManager = LinearLayoutManager(context)
        binding.challengeRecycler.layoutManager = layoutManager
        binding.challengeRecycler.adapter = adapter
        viewModel.init()

        startShimmerEffect()
        viewModel.getchallengesModelLiveData()?.observe(viewLifecycleOwner, {
            if (it != null) {
                isLoading = false
                stopShimmerEffect()
                binding.challengeRecycler.visibility = View.VISIBLE
                adapter.setChallengeList(it.data)
                binding.progressBar.visibility = View.GONE
            }
        })

        viewModel.callChallengesAPI(page)

        //pagination
        binding.challengeRecycler.addOnScrollListener(object : PaginationScrollListener(layoutManager){

            override fun isLastPage(): Boolean {
                 return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }

            override fun loadMoreItems() {
                binding.progressBar.visibility = View.VISIBLE
                isLoading = true
                page++
                viewModel.callChallengesAPI(page)
            }
        })

        return binding.root
    }

    private fun startShimmerEffect() {
        binding.shimmerLayout.shimmerViewContainer.visibility = View.VISIBLE
        binding.shimmerLayout.shimmerViewContainer.startShimmer()
    }

    private fun stopShimmerEffect() {
        binding.shimmerLayout.shimmerViewContainer.visibility = View.GONE
        binding.shimmerLayout.shimmerViewContainer.stopShimmer()
    }
}