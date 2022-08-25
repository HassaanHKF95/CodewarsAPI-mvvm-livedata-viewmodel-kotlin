package com.hassan.codewars.presentation.models

import com.google.gson.annotations.SerializedName

class ChallengesModel {
    @SerializedName("data")
    val data: List<ChallengesListModel>? = null

    @SerializedName("totalItems")
    val totalItems: String? = null


}