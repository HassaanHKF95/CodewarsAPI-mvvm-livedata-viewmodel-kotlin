package com.hassan.codewars.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.hassan.codewars.databinding.ChallengelistItemviewBinding
import com.hassan.codewars.presentation.models.ChallengesListModel
import com.hassan.codewars.R
import com.hassan.codewars.presentation.fragments.ChallengeDetailFragment
import com.hassan.codewars.presentation.fragments.ChallengeListFragment
import com.hassan.codewars.presentation.fragments.ChallengeListFragmentDirections


class ChallengeListAdapter : RecyclerView.Adapter<ChallengeViewHolder>() {
    var challengesList = mutableListOf<ChallengesListModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ChallengelistItemviewBinding.inflate(inflater, parent, false)
        return ChallengeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChallengeViewHolder, position: Int) {
        val challenges = challengesList[position]
        holder.binding.tvChallengeName.text = challenges.name
        holder.binding.tvCreatedAt.text = challenges.completedAt
        holder.binding.tvLanguages.text =
            challenges.completedLanguages.toString().replace("[", "").replace("]", "")
        holder.itemView.setOnClickListener {
            val action = ChallengeListFragmentDirections.listToDetail(challenges)

            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return challengesList.size
    }

    fun setChallengeList(ch: List<ChallengesListModel>?) {
        this.challengesList.addAll(ch!!.toMutableList())
        notifyDataSetChanged()
    }
}

class ChallengeViewHolder(val binding: ChallengelistItemviewBinding) :
    RecyclerView.ViewHolder(binding.root) {
}