package com.vrushabh.newsapp_jetpack_compose.domain.usecases.news

import com.vrushabh.newsapp_jetpack_compose.data.local.NewsDao
import com.vrushabh.newsapp_jetpack_compose.domain.model.Article
import com.vrushabh.newsapp_jetpack_compose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedArticles @Inject constructor(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.getArticles()
    }

}