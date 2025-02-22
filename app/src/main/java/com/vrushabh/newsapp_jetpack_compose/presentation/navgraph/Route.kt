package com.vrushabh.newsapp_jetpack_compose.presentation.navgraph

import androidx.navigation.NamedNavArgument

sealed class Route(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object OnBoardingScreen : Route(route = "onBoardingScreen")

    data object HomeScreen : Route(route = "homeScreen")

    data object SearchScreen : Route(route = "searchScreen")

    data object BookmarkScreen : Route(route = "bookMarkScreen")

    data object DetailsScreen : Route(route = "detailsScreen")

    data object AppStartNavigation : Route(route = "appStartNavigation")

    data object NewsNavigation : Route(route = "newsNavigation")

    data object NewsNavigatorScreen : Route(route = "newsNavigator")
}
