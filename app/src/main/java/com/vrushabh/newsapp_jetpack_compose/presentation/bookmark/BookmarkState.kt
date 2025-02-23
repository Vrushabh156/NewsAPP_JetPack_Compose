package com.vrushabh.newsapp_jetpack_compose.presentation.bookmark

import com.vrushabh.newsapp_jetpack_compose.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)