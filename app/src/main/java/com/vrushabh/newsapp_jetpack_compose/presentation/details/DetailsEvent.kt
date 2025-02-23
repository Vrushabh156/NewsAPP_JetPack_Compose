package com.vrushabh.newsapp_jetpack_compose.presentation.details

import com.vrushabh.newsapp_jetpack_compose.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

     data object RemoveSideEffect : DetailsEvent()

}