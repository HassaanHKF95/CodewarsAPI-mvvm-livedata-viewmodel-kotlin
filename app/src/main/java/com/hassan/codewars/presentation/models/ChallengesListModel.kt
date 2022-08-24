package com.hassan.codewars.presentation.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize


@Parcelize
class ChallengesListModel : Parcelable {

    @IgnoredOnParcel
    @SerializedName("id")
    var id: String? = null

    @IgnoredOnParcel
    @SerializedName("name")
    var name: String? = null

    @IgnoredOnParcel
    @SerializedName("completedAt")
    var completedAt: String? = null

    @IgnoredOnParcel
    @SerializedName("completedLanguages")
    var completedLanguages: List<String>? = null


}