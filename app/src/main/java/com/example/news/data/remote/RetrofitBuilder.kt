package com.example.news.data.remote

import com.example.news.data.remote.responses.NewsResponse
import com.example.news.data.remote.service.NewsService
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitBuilder {

    private val client = OkHttpClient.Builder().build()

    private lateinit var newsService: NewsService

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://hn.algolia.com/api/v1/")
        .addConverterFactory(GsonConverterFactory.create()).client(client).build()

    fun getNews(): Call<NewsResponse> {
        newsService = retrofit.create(NewsService::class.java)
        return newsService.getNews()
    }
}