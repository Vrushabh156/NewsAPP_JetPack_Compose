package com.vrushabh.newsapp_jetpack_compose.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.vrushabh.newsapp_jetpack_compose.data.manger.NewsConnectivityManger
import com.vrushabh.newsapp_jetpack_compose.presentation.news_navigator.NewsNavigator
import com.vrushabh.newsapp_jetpack_compose.presentation.onboarding.OnBoardingScreen
import com.vrushabh.newsapp_jetpack_compose.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String,
    newsConnectivityManger: NewsConnectivityManger
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    onEvent = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {
                NewsNavigator(newsConnectivityManger)
            }
        }
    }
}