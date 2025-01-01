import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import inc.nomard.nomard_hotel_booking_app_jetpack_compose.ui.theme.Nomard_hotel_booking_app_jetpack_composeTheme

@Composable
fun CustomAppBar(
    greeting: String,
    username: String,
    cityLocation: String,
    countryLocation: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "$greeting, $username!",
                style = MaterialTheme.typography.displayLarge,
                color = Color.White
            )
            Text(
                text = "$cityLocation, $countryLocation",
                style = MaterialTheme.typography.displayMedium,
                color = Color.White
            )
        }
        ImageHolder(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            imageSrc = "https://avatars.githubusercontent.com/u/835219?v=4",
            alt = "user profile",
        )
    }
}

@Preview
@Composable
private fun CustomAppBarPreview() {
    Nomard_hotel_booking_app_jetpack_composeTheme {
        CustomAppBar(
            greeting = "Hello",
            username = "Jonathan Mark",
            cityLocation = "Kampala",
            countryLocation = "Uganda",
        )
    }
}
