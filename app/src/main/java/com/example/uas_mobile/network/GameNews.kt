package com.example.uas_mobile.network

import com.squareup.moshi.Json

data class GameNews(
    @Json(name = "title") val title: String,
    @Json(name = "short_description") val short_description :  String,
    @Json(name = "main_image") val main_image: String,
    @Json(name = "article_content") val article_content :  String
)