package com.example.anew.network

import com.example.anew.model.NewsModel
import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("status") val status:String,
    @SerializedName("totalResults") val totalResults:Int,
    @SerializedName("articles") val articles:MutableList<NewsModel>
)
