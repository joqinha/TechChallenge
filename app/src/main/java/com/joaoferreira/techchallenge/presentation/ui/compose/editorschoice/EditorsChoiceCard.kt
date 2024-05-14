package com.joaoferreira.techchallenge.presentation.ui.compose.editorschoice

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.joaoferreira.techchallenge.R

/**
 * Composable containing the editors choice card
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EditorsChoiceCard(
    imageUrl: String,
    description: String,
    rating: Float,
    pagerState: PagerState,
    pageCount: Int,
    maxRating: Float = 5f,
    ratingIcon: ImageVector = Icons.Default.Star
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            EditorsChoiceBackground(background = imageUrl)
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.BottomStart)
            ) {
                if (pageCount > 1) {
                    EditorChoiceIndicator(
                        pagerState = pagerState,
                        pageCount = pageCount
                    )
                }

                Text(
                    text = description,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Clip,
                    style = MaterialTheme.typography.headlineMedium,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = ratingIcon,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.White
                    )
                    Text(
                        text = rating.coerceIn(0f, maxRating).toString(),
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall,
                    )
                }
            }
        }
    }
}

@Composable
private fun EditorsChoiceBackground(background: String) {
    AsyncImage(
        model = background,
        error = painterResource(R.drawable.aptoide_logo),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        alignment = Alignment.Center
    )
}
