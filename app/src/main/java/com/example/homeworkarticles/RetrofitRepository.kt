package com.example.homeworkarticles

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitRepository {

    @GET("articles")
    suspend fun getArticles(): Response<Articles>
}