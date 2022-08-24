package com.hassan.codewars.presentation.models

import com.google.gson.annotations.SerializedName

class ChallengeDetailModel {

    @SerializedName("name")
    var name: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("category")
    var category: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("totalAttempts")
    var totalAttempts: String? = null

    @SerializedName("totalCompleted")
    var totalCompleted: String? = null

    @SerializedName("totalStars")
    var totalStars: String? = null

    @SerializedName("voteScore")
    var voteScore: String? = null

    @SerializedName("publishedAt")
    var publishedAt: String? = null

    @SerializedName("approvedAt")
    var approvedAt: String? = null

    @SerializedName("createdAt")
    var createdAt: String? = null

    @SerializedName("languages")
    var languages: List<String>? = null

    @SerializedName("tags")
    var tags: List<String>? = null

    @SerializedName("createdBy")
    var createdBy: CreatedBy? = null

    @SerializedName("rank")
    var rank: Rank? = null

}

class CreatedBy {
    @SerializedName("username")
    var username: String? = null

    @SerializedName("url")
    var url: String? = null
}

class Rank {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("color")
    var color: String? = null
}