package com.vrushabh.newsapp_jetpack_compose.domain.usecases.news

import com.vrushabh.newsapp_jetpack_compose.data.local.NewsDao
import com.vrushabh.newsapp_jetpack_compose.domain.model.Article
import com.vrushabh.newsapp_jetpack_compose.domain.repository.NewsRepository
import javax.inject.Inject

class UpsertArticle @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article) {
        newsRepository.upsertArticle(article)
    }

}