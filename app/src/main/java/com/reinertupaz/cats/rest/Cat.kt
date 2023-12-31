package com.reinertupaz.cats.rest

import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("id")
    var id: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("width")
    var width: Int,
    @SerializedName("height")
    var height: Int
)
