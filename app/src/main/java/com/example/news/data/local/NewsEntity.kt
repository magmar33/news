package com.example.news.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "story_id") var story_id : Long?,
    @ColumnInfo(name = "created_at") var created_at : String?,
    @ColumnInfo(name = "title") var title : String?,
    @ColumnInfo(name = "url") var url : String?,
    @ColumnInfo(name = "author") var author : String?,
    @ColumnInfo(name = "points") var points : Int?,
    @ColumnInfo(name = "story_text") var story_text : String?,
    @ColumnInfo(name = "comment_text") var comment_text : String?,
    @ColumnInfo(name = "num_comments") var num_comments : String?,
    @ColumnInfo(name = "story_title") var story_title : String?,
    @ColumnInfo(name = "story_url") var story_url : String?,
    @ColumnInfo(name = "parent_id") var parent_id : Long?,
    @ColumnInfo(name = "created_at_i") var created_at_i : Long?,
    @ColumnInfo(name = "objectID") var objectID : String?,

)
