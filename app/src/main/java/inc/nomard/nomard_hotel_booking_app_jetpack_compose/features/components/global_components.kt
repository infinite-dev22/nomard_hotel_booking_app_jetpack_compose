import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import inc.nomard.nomard_hotel_booking_app_jetpack_compose.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageHolder(modifier: Modifier, imageSrc: String, alt: String) {
    GlideImage(
        modifier = modifier,
        model = imageSrc, contentDescription = alt,
        failure = placeholder(R.drawable.ic_launcher_foreground),
        loading = placeholder(R.drawable.ic_launcher_background)
    )
}

@Preview
@Composable
fun CircularProfileImageHolderPreview() {
    inc.nomard.nomard_hotel_booking_app_jetpack_compose.ui.theme.Nomard_hotel_booking_app_jetpack_composeTheme {
        ImageHolder(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            imageSrc = "https://avatars.githubusercontent.com/u/835219?v=4",
            alt = "user profile",
        )
    }
}



