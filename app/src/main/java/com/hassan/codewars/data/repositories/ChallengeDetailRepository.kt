package com.hassan.codewars.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hassan.codewars.data.retrofit.client.RetrofitRestClient
import com.hassan.codewars.data.retrofit.endpoints.ChallengeDetailAPI
import com.hassan.codewars.presentation.models.ChallengeDetailModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChallengeDetailRepository {

    private val challengeDetailLiveData = MutableLiveData<ChallengeDetailModel?>()

    val mApiInterface =
        RetrofitRestClient.getRetrofit().create(ChallengeDetailAPI::class.java)


    fun getChallengeDetailAPI(challenge: String) {
        mApiInterface.getChallengeDetailsAPI(challenge)
            .enqueue(object : Callback<ChallengeDetailModel> {
                override fun onResponse(
                    call: Call<ChallengeDetailModel>,
                    response: Response<ChallengeDetailModel>
                ) {
                    if (response.body() != null)
                        challengeDetailLiveData.value = response.body()
                }

                override fun onFailure(call: Call<ChallengeDetailModel>, t: Throwable) {
                    challengeDetailLiveData.value = null
                }
            })
    }

    open fun getchallengeDetailLiveData(): LiveData<ChallengeDetailModel?>? {
        return challengeDetailLiveData
    }

}
