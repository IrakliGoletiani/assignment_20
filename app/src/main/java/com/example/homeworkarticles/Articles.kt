package com.example.homeworkarticles

class Articles : ArrayList<Article>()

data class Article(
    val id: Int,
    val title: String,
    val url: String,
    val imageUrl: String,
    val newsSite: String,
    val summary: String,
    val publishedAt: String,
    val updatedAt: String,
    val featured: Boolean,
    val launches: List<Any>,
    val events: List<Any>,
)