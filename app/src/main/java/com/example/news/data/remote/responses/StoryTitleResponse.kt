package com.example.news.data.remote.responses

import com.google.gson.annotations.SerializedName

data class StoryTitleResponse(
    @SerializedName("value") val value : String?,
    @SerializedName("matchLevel") val matchLevel : String?,
    @SerializedName("matchedWords") val matchedWords : List<String>?
)
