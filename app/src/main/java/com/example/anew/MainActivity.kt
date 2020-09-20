package com.example.anew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.anew.model.NewsModel
import com.example.anew.network.NewsClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var currentPage=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }
    fun getNews()
    {
        Log.d("AllNews","here")
        NewsClient.fetchNews(currentPage,::onSuccess,::onError)
    }

    private fun onError()
    {
        Log.d("AllNews","here00000")
        Toast.makeText(this,"Failed to get movies", Toast.LENGTH_SHORT).show()
    }

    private fun onSuccess(list: MutableList<NewsModel>)
    {
        Log.d("AllNews","herelllll")
        name.text= list[0].content
    }
}