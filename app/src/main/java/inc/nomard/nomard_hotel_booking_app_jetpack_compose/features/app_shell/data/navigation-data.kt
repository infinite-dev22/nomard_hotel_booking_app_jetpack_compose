package inc.nomard.nomard_hotel_booking_app_jetpack_compose.features.app_shell.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CompassCalibration
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.CompassCalibration
import androidx.compose.material.icons.outlined.HeartBroken
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItem(
    val route: String,
    val icon: ImageVector,
    val unselectedContentColor: Color? = null,
    val selectedContentColor: Color? = null,
    val label: String,
    val hasNews: Boolean? = null,
    val badgeCount: Int? = null
)

sealed class Screen(
    val route: String,
    val label: String,
    val activeIcon: ImageVector,
    val inActiveIcon: ImageVector,
) {
    data object Home : Screen("home", "Home", Icons.Filled.Home, Icons.Outlined.Home)

    data object Explore : Screen(
        "explore",
        "Explore",
        Icons.Filled.CompassCalibration,
        Icons.Outlined.CompassCalibration
    )

    data object Favorite :
        Screen("favorite", "Favorite", Icons.Filled.HeartBroken, Icons.Outlined.HeartBroken)

    data object Settings :
        Screen("settings", "Settings", Icons.Filled.Settings, Icons.Outlined.Settings)
}