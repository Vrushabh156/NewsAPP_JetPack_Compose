package com.vrushabh.newsapp_jetpack_compose.presentation.search

sealed class SearchEvent {

    data class UpdateSearchQuery(val searchQuery: String) : SearchEvent()

    data object SearchNews : SearchEvent()
}