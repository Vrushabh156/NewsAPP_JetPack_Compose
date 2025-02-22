package com.vrushabh.newsapp_jetpack_compose.domain.usecases.news

import androidx.paging.PagingData
import com.vrushabh.newsapp_jetpack_compose.domain.model.Article
import com.vrushabh.newsapp_jetpack_compose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}