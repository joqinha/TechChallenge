package com.joaoferreira.techchallenge.presentation.ui.compose.applist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.joaoferreira.techchallenge.R
import com.joaoferreira.techchallenge.utils.AppConstants.ASPECT_RATIO_BACKGROUND_CARD

/**
 * Composable containing the app card
 */
@Composable
fun AppCard(
    imageUrl: String,
    description: String,
    rating: Float,
    maxRating: Float = 5f,
    ratingIcon: ImageVector = Icons.Default.Star,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 6.dp, vertical = 16.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            AppCardBackground(background = imageUrl)
            Column(modifier = Modifier.width(90.dp)) {
                Text(
                    text = description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 32.dp), // Set a fixed height
                    overflow = TextOverflow.Clip,
                    maxLines = 2
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = ratingIcon,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = rating.coerceIn(0f, maxRating).toString(),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun AppCardBackground(background: String) {
    AsyncImage(
        model = background,
        error = painterResource(R.drawable.aptoide_logo),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(90.dp)
            .aspectRatio(ASPECT_RATIO_BACKGROUND_CARD)
            .padding(bottom = 4.dp),
        alignment = Alignment.Center,
    )
}
