package com.example.anew.network

import android.util.Log
import com.example.anew.model.NewsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsClient {
    val BASE_URL="https://newsapi.org/v2/"
    val service: APIServices
    init {
        Log.d("AllNews","here33333")

        val retrofit=
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        service =retrofit.create(APIServices::class.java)
    }
    fun fetchNews(page:Int=1, onSuccess:(newsList:MutableList<NewsModel>)->Unit, onError:()->Unit)
    {           Log.d("AllNews","here222222")

        service.getAllNews(pageNumber = page).enqueue(object : Callback<NewsResponse>
        {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.d("AllNews","h77777")

                onError.invoke()
            }

            override fun onResponse(
                call: Call<NewsResponse>,
                response: Response<NewsResponse>
            ) {

                if (response.isSuccessful)
                {                 Log.d("AllNews","here8888")

                    if (response.body()!=null)
                    {
                        onSuccess.invoke(response.body()!!.articles)
                    }
                    else
                    {
                        onError.invoke()
                    }
                }
                else
                {
                    Log.d("AllNews",response.code().toString())
                    Log.d("AllNews",response.errorBody().toString())

                }
            }
        })
    }
}