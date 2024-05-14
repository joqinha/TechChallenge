package com.joaoferreira.techchallenge.presentation.ui.compose.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.joaoferreira.techchallenge.R
import com.joaoferreira.techchallenge.allapps.domain.AppDetails

/**
 * Popup composable
 */
@Composable
fun PopUp(
    appDetails: AppDetails,
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
                AppIcon(appDetails.graphicUrl ?: "")
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
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.aptoide_orange),
                            contentColor = Color.White
                        ),
                        onClick = { setDemoModeWarning(true) }
                    ) {
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

@Suppress("MagicNumber")
private fun Long.toMegabytesText(): String {
    val megaBytes = (this.toDouble() / (1024 * 1024))
    return "%.1f".format(megaBytes)
}
