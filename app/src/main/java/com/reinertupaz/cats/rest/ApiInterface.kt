package com.reinertupaz.cats.rest

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/v1/images/search?limit=10")
    suspend fun getCats(): Response<List<Cat>>
}