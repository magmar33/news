package com.example.news.data.local

import androidx.room.*

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(news: NewsEntity)

    @Update
    fun update(news: NewsEntity)

    @Delete
    fun delete(news: NewsEntity)

    @Query("select * from news")
    fun getNews(): List<NewsEntity>


}