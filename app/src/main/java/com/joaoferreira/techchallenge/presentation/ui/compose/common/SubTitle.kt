package com.joaoferreira.techchallenge.presentation.ui.compose.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.joaoferreira.techchallenge.R

/**
 * Subtitle composable function
 */
@Composable
fun SubTitle(
    leftSideText: String = "",
    rightSideText: String = "More"
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = leftSideText,
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 20.dp),
            text = rightSideText,
            color = colorResource(R.color.aptoide_orange),
            style = MaterialTheme.typography.titleMedium
        )
    }
}
