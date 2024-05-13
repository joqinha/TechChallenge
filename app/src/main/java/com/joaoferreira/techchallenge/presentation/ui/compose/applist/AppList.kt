package com.joaoferreira.techchallenge.presentation.ui.compose.applist

import android.icu.text.CaseMap.Title
import android.provider.MediaStore.Downloads
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.window.Popup
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.joaoferreira.techchallenge.R
import com.joaoferreira.techchallenge.allapps.domain.AppData
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
                        Popup(
                            appDetails = app,
                            onDismissRequest = { setShowPopupButton(false) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Popup(
    appDetails: AppData,
    onDismissRequest: () -> Unit
) {
    val (showDemoModeWarning, setDemoModeWarning) = remember { mutableStateOf(false) }

    AlertDialog(
        modifier = Modifier
            .padding(4.dp)
            .width(500.dp)
            .height(400.dp),
        onDismissRequest = onDismissRequest,
        title = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppIcon(appDetails.graphicUrl)
                Text(appDetails.name, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        },
        text = {
            Column {
                Text("Downloads: ${appDetails.downloads}")
                Text("Size: ${appDetails.size.toMegabytesText()} MB")
                Text("Version: ${appDetails.versionName}")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = { setDemoModeWarning(true) }) {
                        Text(text = "Download")
                    }
                }
                if (showDemoModeWarning) {
                    Text(
                        text = "This functionality is not available in demo mode",
                        overflow = TextOverflow.Visible,
                        maxLines = 2
                    )
                }
            }
        },
        confirmButton = { },
    )
}

@Composable
private fun AppIcon(background: String) {
    AsyncImage(
        model = background,
        contentDescription = null,
        contentScale = ContentScale.Fit,
        alignment = Alignment.Center,
    )
}

private fun Long.toMegabytesText(): String {
    val megaBytes = (this.toDouble() / (1024 * 1024))
    return "%.1f".format(megaBytes)
}