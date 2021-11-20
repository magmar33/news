package com.example.news.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.data.domain.News

class NewsAdapter (
    private var news : MutableList<News>,


    ) : RecyclerView.Adapter<NewsViewHolder>(){
    fun updateData(news: MutableList<News>){
        this.news = news
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       val news = news[position]

        holder.tvTitle.text = news.story_title
        holder.tvDescription.text = news.comment_text
    }

    override fun getItemCount(): Int = news.size
}