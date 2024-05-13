package com.joaoferreira.techchallenge.presentation.ui.compose.applist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.joaoferreira.techchallenge.R
import com.joaoferreira.techchallenge.allapps.presentation.ui.AppsViewModel

/**
 * Composable containing the app list
 */
@Composable
fun AppList(appsViewModel: AppsViewModel = hiltViewModel()) {
    val allAppsFlow = appsViewModel.listOfApps.collectAsState()
    val stateSize = rememberLazyListState(Int.MAX_VALUE / 2)
    Column {
        if (allAppsFlow.value.isNotEmpty()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "Local top apps",
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
                    val app = allAppsFlow.value[appItem % allAppsFlow.value.size]

                    val (showPopupButton, setShowPopupButton) = remember { mutableStateOf(false) }
                    AppCard(
                        imageUrl = app.iconUrl,
                        description = app.name,
                        rating = app.rating.toFloat(),
                        onClick = { setShowPopupButton(true) }
                    )

                    if (showPopupButton) {
                        Popup(onDismissRequest = {setShowPopupButton(false)})
                    }
                }
            }
        }
    }
}

@Composable
fun Popup(
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text("Popup Title") },
        text = { Text("Popup Content") },
        confirmButton = {
            Button(onClick = onDismissRequest) {
                Text("Confirm")
            }
        },
        dismissButton = {
            Button(onClick = onDismissRequest) {
                Text("Dismiss")
            }
        }
    )
}
