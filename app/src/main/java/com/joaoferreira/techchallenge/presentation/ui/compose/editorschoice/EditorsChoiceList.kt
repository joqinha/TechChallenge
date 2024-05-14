package com.joaoferreira.techchallenge.presentation.ui.compose.editorschoice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.joaoferreira.techchallenge.allapps.presentation.ui.AppsViewModel

/**
 * Composable containing the editors choice list
 */
@Composable
fun EditorsChoiceList(appsViewModel: AppsViewModel = hiltViewModel()) {
    val allAppsFlow = appsViewModel.listOfApps.collectAsState()
    val stateSize = rememberLazyListState(Int.MAX_VALUE / 2)

    val editorsChoiceList = allAppsFlow.value.filter { it.rating > 4.5 }

    if (editorsChoiceList.isNotEmpty()) {
        Column {
            if (editorsChoiceList.isNotEmpty()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = "Editors choice",
                        style = MaterialTheme.typography.titleLarge,
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(end = 20.dp),
                        text = "More",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                LazyRow(
                    modifier = Modifier.testTag("AppList"),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        4.dp
                    ),
                    state = stateSize,
                ) {
                    items(Int.MAX_VALUE) { appItem ->
                        val app = editorsChoiceList[appItem % editorsChoiceList.size]
                        EditorsChoiceCard(
                            imageUrl = app.graphicUrl ?: app.iconUrl ?: "",
                            description = app.name,
                            rating = app.rating.toFloat()
                        )
                    }
                }
            }
        }
    }
}
