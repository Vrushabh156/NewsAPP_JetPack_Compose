package com.vrushabh.newsapp_jetpack_compose.presentation.home

data class HomeState(
    val newsTicker: String = "",
    val isLoading: Boolean = false,
)