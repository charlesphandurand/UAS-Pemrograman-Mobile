package com.example.uas_mobile.network

import com.squareup.moshi.Json

data class GameWeb(
    @Json(name = "title") val title: String,
    @Json(name = "thumbnail") val thumbnail: String,
    @Json(name = "short_description") val short_description :  String,
    @Json(name = "genre") val genre :  String,
    @Json(name = "platform") val platform :  String,
    @Json(name = "developer") val developer :  String
)