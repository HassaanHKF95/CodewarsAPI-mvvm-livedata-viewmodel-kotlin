package com.hassan.codewars.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.hassan.codewars.databinding.FragmentChallengeDetailBinding
import com.hassan.codewars.presentation.models.ChallengeDetailModel
import com.hassan.codewars.presentation.models.viewModels.ChallengeDetailViewModel
import com.hassan.codewars.presentation.models.viewModels.ChallengesListViewModel

class ChallengeDetailFragment : Fragment() {
    private lateinit var binding: FragmentChallengeDetailBinding
    private val args: ChallengeDetailFragmentArgs by navArgs()
    lateinit var viewModel: ChallengeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChallengeDetailBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(ChallengeDetailViewModel::class.java)
        viewModel.init()

        startShimmerEffect()

        viewModel.getchallengeDetailLiveData()?.observe(viewLifecycleOwner, {
            if (it != null) {
                stopShimmerEffect()
                showLayouts()
                populateData(it)
            }
        })

        viewModel.callChallengeDetailAPI(args.challenge.id.toString())


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

    private fun showLayouts() {
        binding.scrollView.visibility = View.VISIBLE
        binding.tvName.visibility = View.VISIBLE
        binding.tvUser.visibility = View.VISIBLE
        binding.view.visibility = View.VISIBLE
    }

    private fun populateData(it: ChallengeDetailModel) {
        binding.tvName.text = it.name
        binding.tvUser.text = it.createdBy?.username
        binding.tvDescription.text = it.description
        binding.tvTags.text =
            it.tags.toString().replace("[", "").replace("]", "").replace(",", " |")
        binding.tvLanguages.text =
            it.languages.toString().replace("[", "").replace("]", "")
        binding.tvCategory.text = it.category
        binding.tvTotalAttempts.text = it.totalAttempts
        binding.tvTotalCompleted.text = it.totalCompleted
        binding.tvTotalStar.text = it.totalStars
        binding.tvVoteScore.text = it.voteScore
        binding.tvPublishedAt.text = it.publishedAt
        binding.tvCreatedAt.text = it.createdAt
    }
}