package com.example.news.presentation.adapters

import com.example.news.data.domain.News

interface NewsInteractor {
    fun goToDetail(news : News)
    fun goToDelete(position : Int)

}