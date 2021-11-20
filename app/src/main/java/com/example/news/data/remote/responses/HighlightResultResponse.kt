package com.example.news.data.remote.responses

import com.google.gson.annotations.SerializedName

data class HighlightResultResponse (
        @SerializedName("author") val author : AuthorResponse?,
        @SerializedName("comment_text") val comment_text: CommentTextResponse?,
        @SerializedName("story_title") val story_title : StoryTitleResponse?,
        @SerializedName("story_url") val story_url : StoryUrlResponse?,
        )
