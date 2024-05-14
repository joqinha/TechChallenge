package com.joaoferreira.techchallenge.presentation.ui.compose.applist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.joaoferreira.techchallenge.allapps.presentation.ui.AppsViewModel
import com.joaoferreira.techchallenge.presentation.ui.compose.common.PopUp
import com.joaoferreira.techchallenge.presentation.ui.compose.common.SubTitle

/**
 * Composable containing the app list
 */
@Composable
fun AppList(appsViewModel: AppsViewModel = hiltViewModel()) {
    val allAppsFlow = appsViewModel.listOfApps.collectAsState()
    val stateSize = rememberLazyListState(Int.MAX_VALUE / 2)
    if (allAppsFlow.value.isNotEmpty()) {
        Column {
            if (allAppsFlow.value.isNotEmpty()) {
                SubTitle(
                    leftSideText = "Local top apps"
                )
                LazyRow(
                    modifier = Modifier.testTag("AppList"),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        4.dp
                    ),
                    state = stateSize,
                ) {
                    items(Int.MAX_VALUE) { appItem ->
                        if (allAppsFlow.value.isNotEmpty()) {
                            val app = allAppsFlow.value[appItem % allAppsFlow.value.size]

                            val (showPopupButton, setShowPopupButton) = remember {
                                mutableStateOf(
                                    false
                                )
                            }
                            AppCard(
                                imageUrl = app.iconUrl,
                                description = app.name,
                                rating = app.rating.toFloat(),
                                onClick = { setShowPopupButton(true) }
                            )

                            if (showPopupButton) {
                                PopUp(
                                    appDetails = app,
                                    onDismissRequest = { setShowPopupButton(false) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
