package com.example.news.data.domain

import com.example.news.data.local.NewsEntity
import com.example.news.data.remote.responses.HighlightResultResponse
import com.example.news.data.remote.responses.HitItemResponse


data class News (
    val created_at: String?,
    val title: String?,
    val url: String?,
    val author: String?,
    val points: Int?,
    val story_text: String?,
    val comment_text: String?,
    val num_comments: String?,
    val story_id: Long?,
    val story_title: String?,
    val story_url: String?,
    val parent_id: Long?,
    val created_at_i: Long?,
    val objectID: String?,
){
    companion object{
        fun responseToDomain(hitItemResponse: HitItemResponse) =
            News(
                hitItemResponse.created_at,
                hitItemResponse.title,
                hitItemResponse.url,
                hitItemResponse.author,
                hitItemResponse.points,
                hitItemResponse.story_text,
                hitItemResponse.comment_text,
                hitItemResponse.num_comments,
                hitItemResponse.story_id,
                hitItemResponse.story_title,
                hitItemResponse.story_url,
                hitItemResponse.parent_id,
                hitItemResponse.created_at_i,
                hitItemResponse.objectID
            )

        fun responseToEntity(hitItemResponse: HitItemResponse)=
            NewsEntity(
                hitItemResponse.story_id,
                hitItemResponse.created_at,
                hitItemResponse.title,
                hitItemResponse.url,
                hitItemResponse.author,
                hitItemResponse.points,
                hitItemResponse.story_text,
                hitItemResponse.comment_text,
                hitItemResponse.num_comments,
                hitItemResponse.story_title,
                hitItemResponse.story_url,
                hitItemResponse.parent_id,
                hitItemResponse.created_at_i,
                hitItemResponse.objectID
            )

        fun entityToDomain(newsEntity: NewsEntity)=
            News(
                newsEntity.created_at,
                newsEntity.title,
                newsEntity.url,
                newsEntity.author,
                newsEntity.points,
                newsEntity.story_text,
                newsEntity.comment_text,
                newsEntity.num_comments,
                newsEntity.story_id,
                newsEntity.story_title,
                newsEntity.story_url,
                newsEntity.parent_id,
                newsEntity.created_at_i,
                newsEntity.objectID
            )
    }


}

