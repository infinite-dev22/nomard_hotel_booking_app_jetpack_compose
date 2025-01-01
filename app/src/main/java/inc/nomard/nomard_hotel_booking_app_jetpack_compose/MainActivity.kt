package inc.nomard.nomard_hotel_booking_app_jetpack_compose

import CustomBottomBar
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import inc.nomard.jetpackcomposetestlookbackpractice.ui.components.NavHostContainer
import inc.nomard.nomard_hotel_booking_app_jetpack_compose.features.app_shell.data.Screen
import inc.nomard.nomard_hotel_booking_app_jetpack_compose.ui.theme.Nomard_hotel_booking_app_jetpack_composeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Nomard_hotel_booking_app_jetpack_composeTheme {
                val navController = rememberNavController()
                val screens = listOf(
                    Screen.Home,
                    Screen.Explore,
                    Screen.Favorite,
                    Screen.Settings,
                )

                Scaffold(
                    floatingActionButton = { CustomBottomBar(navController, screens) },
                    floatingActionButtonPosition = FabPosition.Center,
                    content = {
                        NavHostContainer(navController)
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Nomard_hotel_booking_app_jetpack_composeTheme {
        Greeting("Android")
    }
}