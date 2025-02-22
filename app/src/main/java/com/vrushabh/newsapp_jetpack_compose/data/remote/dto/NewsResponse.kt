package com.vrushabh.newsapp_jetpack_compose.data.remote.dto

import com.vrushabh.newsapp_jetpack_compose.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)