package com.joaoferreira.techchallenge.presentation.ui.compose.editorschoice

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.joaoferreira.techchallenge.allapps.presentation.ui.AppsViewModel
import com.joaoferreira.techchallenge.presentation.ui.compose.common.SubTitle
import com.joaoferreira.techchallenge.utils.AppConstants.EDITORS_CHOICE_RATING

/**
 * Composable containing the editors choice list
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EditorsChoiceList(appsViewModel: AppsViewModel = hiltViewModel()) {
    val allAppsFlow = appsViewModel.listOfApps.collectAsState()
    val editorsChoiceList = allAppsFlow.value.filter { it.rating > EDITORS_CHOICE_RATING }

    if (editorsChoiceList.isNotEmpty()) {
        Column {
            val pagerState = rememberPagerState()
            val pageCount = editorsChoiceList.size
            SubTitle(
                leftSideText = "Editors choice"
            )
            HorizontalPager(
                modifier = Modifier
                    .weight(1.0f),
                state = pagerState,
                pageCount = pageCount,
                beyondBoundsPageCount = 1
            ) { page ->
                val app = editorsChoiceList[page]
                EditorsChoiceCard(
                    pagerState = pagerState,
                    pageCount = pageCount,
                    imageUrl = app.graphicUrl ?: app.iconUrl,
                    description = app.name,
                    rating = app.rating.toFloat()
                )
            }
        }
    }
}
