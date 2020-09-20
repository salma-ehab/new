package com.example.anew.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIServices {
    @GET("everything")
    fun getAllNews(@Query("apiKey") apiKey:String="7b68ee98ace74ebaa81eac2d8ee911ec",@Query("page") pageNumber:Int=1)
    :Call<NewsResponse>
}