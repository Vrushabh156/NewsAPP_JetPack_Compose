package com.vrushabh.newsapp_jetpack_compose.domain.repository

import androidx.paging.PagingData
import com.vrushabh.newsapp_jetpack_compose.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>

    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>
}