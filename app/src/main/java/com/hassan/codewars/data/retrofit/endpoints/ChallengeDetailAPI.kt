package com.hassan.codewars.data.retrofit.endpoints

import com.hassan.codewars.presentation.models.ChallengeDetailModel
import com.hassan.codewars.presentation.models.ChallengesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ChallengeDetailAPI {
    @GET("code-challenges/{challenge}")
    fun getChallengeDetailsAPI(
        @Path("challenge") challenge: String?
    ): Call<ChallengeDetailModel>
}