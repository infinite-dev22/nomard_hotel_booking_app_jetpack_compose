import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import inc.nomard.jetpackcomposetestlookbackpractice.ui.components.NavHostContainer
import inc.nomard.nomard_hotel_booking_app_jetpack_compose.features.app_shell.data.Screen
import inc.nomard.nomard_hotel_booking_app_jetpack_compose.ui.theme.Nomard_hotel_booking_app_jetpack_composeTheme

@SuppressLint("RememberReturnType")
@Composable
fun CustomBottomBar(
    navController: NavController,
    screens: List<Screen>
) {
    var selectedScreen by remember { mutableIntStateOf(0) }
    Surface(
        shadowElevation = 5.dp,
        modifier = Modifier.padding(horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            for (screen in screens) {
                val isSelected = screen == screens[selectedScreen]
                Box(
                    modifier = Modifier.weight(if (isSelected) 1.5f else 1f),
                    contentAlignment = Alignment.Center
                ) {
                    val interactionSource = remember { MutableInteractionSource() }
                    CustomBottomBarItem(
                        modifier = Modifier.clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            selectedScreen = screens.indexOf(screen)
                            navController.navigate(screen.route)
                        },
                        screen = screen, isSelected = isSelected,
                    )
                }
            }
        }
    }
}

@Composable
fun CustomBottomBarItem(
    modifier: Modifier = Modifier,
    screen: Screen,
    isSelected: Boolean,
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier
                .width(if (isSelected) 120.dp else 40.dp)
                .height(if (isSelected) 50.dp else 30.dp)
                .background(
                    color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(50.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                rememberVectorPainter(image = if (isSelected) screen.activeIcon else screen.inActiveIcon),
                contentDescription = screen.label,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxHeight()
                    .padding(start = 11.dp)
                    .alpha(if (isSelected) 1f else .5f)
                    .size(if (isSelected) 26.dp else 20.dp),
                tint = if (isSelected) Color.White else Color.Black,
            )
            if (isSelected) {
                Text(
                    text = screen.label,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 10.dp),
                    color = Color.White,
                    maxLines = 1,
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true)
fun CustomBottomBarPreview() {
    val navController = rememberNavController()
    val screens = listOf(
        Screen.Home,
        Screen.Explore,
        Screen.Favorite,
        Screen.Settings,
    )
    Scaffold(
        floatingActionButton = {
            CustomBottomBar(navController, screens)
        },
        floatingActionButtonPosition = FabPosition.Center,
        content = {
            NavHostContainer(navController)
        }
    )
}

@Preview
@Composable
private fun CustomBottomBarItemPreview() {
    Nomard_hotel_booking_app_jetpack_composeTheme {
        CustomBottomBarItem(
            modifier = Modifier,
            screen = Screen.Home,
            isSelected = true,
        )
    }
}
