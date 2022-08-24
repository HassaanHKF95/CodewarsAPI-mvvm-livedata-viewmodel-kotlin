package com.hassan.codewars.presentation.models.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import com.hassan.codewars.data.repositories.CodeWarRepository
import com.hassan.codewars.presentation.models.ChallengesModel


class ChallengesListViewModel : ViewModel() {

    private val challengesRepository: CodeWarRepository = CodeWarRepository()
    private var challengesModelLiveData: LiveData<ChallengesModel?>? = null

    fun init() {
        challengesModelLiveData = challengesRepository.getchallengesResponseLiveData()
    }
    fun callChallengesAPI(page: String){
        challengesRepository.getChallengesListAPI(page)
    }

    fun getchallengesModelLiveData(): LiveData<ChallengesModel?>? {
        return challengesModelLiveData
    }
}