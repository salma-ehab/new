package com.example.anew.model

import com.google.gson.annotations.SerializedName

data class NewsModel (
    @SerializedName("source") val source: SourceModel,
    @SerializedName("author") val author:String,
    @SerializedName("title") val title:String,
    @SerializedName("description") val desciption:String,
    @SerializedName("url") val url:String,
    @SerializedName("urlToImage") val urlToImage:String,
    @SerializedName("publishedAt") val publishedAt:String,
    @SerializedName("content") val content:String
)
