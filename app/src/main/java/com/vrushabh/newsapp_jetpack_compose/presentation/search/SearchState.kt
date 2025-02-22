package com.vrushabh.newsapp_jetpack_compose.presentation.search

import androidx.paging.PagingData
import com.vrushabh.newsapp_jetpack_compose.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)