package com.hassan.codewars.presentation.models.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hassan.codewars.data.repositories.ChallengeDetailRepository
import com.hassan.codewars.presentation.models.ChallengeDetailModel

class ChallengeDetailViewModel : ViewModel() {

    private val challengeDetailRepository: ChallengeDetailRepository = ChallengeDetailRepository()
    private var challengeDetailLiveData: LiveData<ChallengeDetailModel?>? = null

    fun init() {
        challengeDetailLiveData = challengeDetailRepository.getchallengeDetailLiveData()
    }
    fun callChallengeDetailAPI(challenge: String){
        challengeDetailRepository.getChallengeDetailAPI(challenge)
    }

    fun getchallengeDetailLiveData(): LiveData<ChallengeDetailModel?>? {
        return challengeDetailLiveData
    }
}