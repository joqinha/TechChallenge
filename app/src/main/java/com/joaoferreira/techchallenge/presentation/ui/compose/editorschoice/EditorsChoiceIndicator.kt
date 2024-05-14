package com.joaoferreira.techchallenge.presentation.ui.compose.editorschoice

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.joaoferreira.techchallenge.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * EditorsChoice Page Indicator Component
 * */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EditorChoiceIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    pageCount: Int,
    selectedIndicatorBackground: Color = colorResource(R.color.aptoide_orange),
    normalIndicatorSize: Dp = 5.dp,
    selectedIndicatorWidth: Dp = 10.dp,
    indicatorElevation: Dp = 10.dp
) {
    val coroutineScope = rememberCoroutineScope()
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Indicator(
            pageCount = pageCount,
            coroutineScope = coroutineScope,
            pagerState = pagerState,
            indicatorElevation = indicatorElevation,
            normalIndicatorSize = normalIndicatorSize,
            modifier = Modifier
                .shadow(elevation = indicatorElevation)
                .clip(RoundedCornerShape(normalIndicatorSize))
                .background(selectedIndicatorBackground)
                .size(selectedIndicatorWidth, normalIndicatorSize)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Indicator(
    pageCount: Int,
    coroutineScope: CoroutineScope,
    pagerState: PagerState,
    indicatorElevation: Dp,
    normalIndicatorSize: Dp,
    modifier: Modifier
) {
    repeat(pageCount) { iteration ->
        Surface(
            onClick = {
                coroutineScope.launch {
                    pagerState.scrollToPage(iteration)
                }
            },
            color = Color.Transparent
        ) {
            if (pagerState.currentPage == iteration) {
                Box(
                    modifier = modifier
                )
            } else {
                Box(
                    modifier = Modifier
                        .shadow(elevation = indicatorElevation)
                        .clip(CircleShape)
                        .size(normalIndicatorSize)
                )
            }
        }
    }
}
