package com.hassan.codewars.data.retrofit.endpoints


import com.hassan.codewars.presentation.models.ChallengesListModel
import com.hassan.codewars.presentation.models.ChallengesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ListOfCompletedChallengesAPI {

    @GET("users/Voile/code-challenges/completed")
    fun getListOfCompletedChallengesAPI(
        @Query("page") query: String?
    ): Call<ChallengesModel>
}