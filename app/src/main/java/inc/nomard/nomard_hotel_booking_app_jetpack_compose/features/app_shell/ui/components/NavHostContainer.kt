package inc.nomard.jetpackcomposetestlookbackpractice.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import inc.nomard.nomard_hotel_booking_app_jetpack_compose.features.app_shell.data.Screen
import inc.nomard.nomard_hotel_booking_app_jetpack_compose.features.explore.ui.ExploreScreen
import inc.nomard.nomard_hotel_booking_app_jetpack_compose.features.favorite.ui.FavoriteScreen
import inc.nomard.nomard_hotel_booking_app_jetpack_compose.features.home.ui.HomeScreen
import inc.nomard.nomard_hotel_booking_app_jetpack_compose.features.settings.ui.SettingsScreen

@Composable
fun NavHostContainer(
    navController: NavHostController
) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen() }
        composable(Screen.Explore.route) { ExploreScreen() }
        composable(Screen.Favorite.route) { FavoriteScreen() }
        composable(Screen.Settings.route) { SettingsScreen() }
    }
}