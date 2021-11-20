package com.example.news.presentation.main

import com.example.news.data.domain.News

interface MainController {
    interface View{
        fun setError(msg : String)
        fun setNews(news : MutableList<News>)
    }

    interface Presenter{
        fun getNews()
    }
}