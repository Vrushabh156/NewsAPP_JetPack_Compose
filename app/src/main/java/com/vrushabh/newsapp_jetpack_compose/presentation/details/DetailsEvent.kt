package com.vrushabh.newsapp_jetpack_compose.presentation.details

sealed class DetailsEvent {

    data object SaveArticle : DetailsEvent()

}