package com.vrushabh.newsapp_jetpack_compose.presentation.onboarding

sealed class OnBoardingEvent {

    data object SaveAppEntry : OnBoardingEvent()

}