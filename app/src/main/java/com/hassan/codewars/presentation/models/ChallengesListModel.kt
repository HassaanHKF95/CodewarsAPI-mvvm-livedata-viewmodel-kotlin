package com.hassan.codewars.presentation.models

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
class ChallengesListModel : Parcelable {

    @SerializedName("name")
    var name: String? = null

    @SerializedName("completedAt")
    var completedAt: String? = null

    @SerializedName("completedLanguages")
    var completedLanguages: List<String>?=null


}