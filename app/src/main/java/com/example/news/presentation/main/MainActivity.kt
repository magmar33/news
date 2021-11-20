package com.example.news.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.ViewAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.data.domain.News
import com.example.news.presentation.adapters.NewsAdapter


class MainActivity : AppCompatActivity(), MainController.View {
    lateinit var rvNews : RecyclerView
    lateinit var adapter : NewsAdapter
    private lateinit var presenter: MainPresenter
    private lateinit var tv_message_empty : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this, this)
        rvNews = findViewById(R.id.rvNews)

        adapter = NewsAdapter(mutableListOf())
        rvNews.setHasFixedSize(true)
        rvNews.layoutManager = LinearLayoutManager(this)
        rvNews.adapter = adapter

        tv_message_empty= findViewById(R.id. tv_message_empty)

    }

    override fun onResume() {
        super.onResume()
        presenter.getNews()
    }
    override fun setError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun setNews(news : MutableList<News>) {
        //Toast.makeText(this,news.size.toString(),Toast.LENGTH_SHORT).show()

        if(news.isEmpty()){
            tv_message_empty.visibility = ViewAnimator.VISIBLE
        }else
        {
            tv_message_empty.visibility = ViewAnimator.INVISIBLE
            adapter.updateData(news)
        }

    }
}