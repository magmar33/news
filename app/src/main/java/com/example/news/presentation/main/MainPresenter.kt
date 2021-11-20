package com.example.news.presentation.main

import android.content.Context
import com.example.news.data.domain.News
import com.example.news.data.domain.News.Companion.entityToDomain
import com.example.news.data.local.MyDatabase
import com.example.news.data.remote.RetrofitBuilder
import com.example.news.data.remote.responses.NewsResponse
import com.example.news.utils.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter(val view: MainController.View,private val context: Context) : MainController.Presenter{
    private val retrofit = RetrofitBuilder()
    private val database = MyDatabase.invoke(context)
    override fun getNews() {
        if (Network.isOnline(context)) {
            retrofit.getNews().enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()!!.hits!!.forEach { new ->
                            if (!new.story_title.isNullOrEmpty() && !new.comment_text.isNullOrEmpty() && new.story_id != null) {
                                database.newsDao().insert(News.responseToEntity(new))
                            }
                        }

                        val news = database.newsDao().getNews().map(::entityToDomain)
                        view.setNews(news.toMutableList())


                        /*// Log.i("TAG", "${response.body()}")
                   // val news = response.body()!!.hits!!.map { newResponse ->
                        //News.responseToDomain(newResponse)
                     val news = mutableListOf<News>()
                    response.body()!!.hits!!.forEach { new ->
                        if (!new.story_title.isNullOrEmpty() && !new.comment_text.isNullOrEmpty()){
                            news.add(News.responseToDomain(new))
                        }

                        //News.responseToDomain(newResponse)
                    }
                    view.setNews(news.toMutableList())*/
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    view.setError(t.message.toString())
                }


            })
        } else {
            val news = database.newsDao().getNews().map(::entityToDomain)
            view.setNews(news.toMutableList())
        }
    }
}