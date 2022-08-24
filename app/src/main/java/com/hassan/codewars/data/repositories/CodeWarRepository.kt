package com.hassan.codewars.data.repositories

import com.hassan.codewars.data.retrofit.client.RetrofitRestClient
import com.hassan.codewars.data.retrofit.endpoints.ListOfCompletedChallengesAPI
import com.hassan.codewars.presentation.models.ChallengesListModel
import com.hassan.codewars.presentation.models.ChallengesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData


open class CodeWarRepository {

    private val challengesResponseLiveData = MutableLiveData<ChallengesModel?>()

    val mApiInterface =
        RetrofitRestClient.getRetrofit().create(ListOfCompletedChallengesAPI::class.java)


    fun getChallengesListAPI(page: String) {
        mApiInterface.getListOfCompletedChallengesAPI(page)
            .enqueue(object : Callback<ChallengesModel> {
                override fun onResponse(
                    call: Call<ChallengesModel>,
                    response: Response<ChallengesModel>
                ) {
                    if (response.body() != null)
                        challengesResponseLiveData.value = response.body()
                }

                override fun onFailure(call: Call<ChallengesModel>, t: Throwable) {
                    challengesResponseLiveData.value = null
                }
            })
    }

    open fun getchallengesResponseLiveData(): LiveData<ChallengesModel?>? {
        return challengesResponseLiveData
    }

}