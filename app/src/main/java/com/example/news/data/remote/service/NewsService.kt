package com.example.news.data.remote.service

import com.example.news.data.remote.responses.NewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @GET("search_by_date?query=money")
    fun getNews(): Call<NewsResponse>

}