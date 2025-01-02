import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Composable
fun SearchField() {
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 49.dp, max = 50.dp),
        value = value,
        onValueChange = {
            value = it
        },
        maxLines = 1,
        singleLine = true,
        placeholder = { Text(text = "Search") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
        shape = RoundedCornerShape(8.dp),
    )
}

@Composable
fun CustomChipButton(text: String, value: Boolean, onSelected: (Boolean) -> Unit) {
    var isSelected by remember { mutableStateOf(value) }
    Surface {
        Column(
            modifier = Modifier
                .size(80.dp, 30.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(6.dp)
                )
                .background(
                    color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(6.dp)
                )
                .clickable {
                    isSelected = !isSelected
                    onSelected.invoke(isSelected)
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = text,
                color = if (isSelected) Color.White else Color.Black,
            )
        }
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

@Preview
@Composable
private fun SearchFieldPreview() {
    Nomard_hotel_booking_app_jetpack_composeTheme {
        SearchField()
    }
}

@Preview
@Composable
private fun CustomChipButtonPreview() {
    Nomard_hotel_booking_app_jetpack_composeTheme {
        var isSelected by remember { mutableStateOf(true) }
        Row(modifier = Modifier.height(80.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            CustomChipButton(
                text = "All",
                value = false,
                onSelected = {
                    isSelected = it
                },
            )
            CustomChipButton(
                text = "All",
                value = true,
                onSelected = {
                    isSelected = it
                },
            )
        }
    }
}
