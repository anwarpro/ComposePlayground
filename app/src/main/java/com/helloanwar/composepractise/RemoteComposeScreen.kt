package com.helloanwar.composepractise

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.remote.creation.compose.capture.rememberRemoteDocument
import androidx.compose.remote.creation.compose.layout.RemoteColumn
import androidx.compose.remote.creation.compose.layout.RemoteText
import androidx.compose.remote.creation.compose.state.RemoteColor
import androidx.compose.remote.player.compose.RemoteDocumentPlayer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity

@SuppressLint("RestrictedApi") // This is the magic line
@Composable
fun RemoteComposeScreen() {
    val context = LocalContext.current
    val density = LocalDensity.current

    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }


    val document by rememberRemoteDocument {
        RemoteColumn {
            RemoteText(
                text = "Hello from RemoteCompose!",
                color = RemoteColor.fromARGB(1f, 1f, 0f, 0f)
            )
            RemoteText(
                text = "This UI is rendered natively via RemoteCompose.",
                color = RemoteColor.fromARGB(1f, 1f, 0f, 0f)
            )
        }
    }

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val widthPx =
            with(density) { constraints.maxWidth.let { if (it == Int.MAX_VALUE) 1080 else it } }
        val heightPx =
            with(density) { constraints.maxHeight.let { if (it == Int.MAX_VALUE) 1920 else it } } // Fallback for scrollable parents

        if (document != null) {
            RemoteDocumentPlayer(
                document = document!!,
                documentWidth = widthPx,
                documentHeight = heightPx,
                modifier = Modifier.fillMaxSize(),
                onNamedAction = { name, value, _ ->
                    println("Action: $name, Value: $value")
                }
            )
        } else {
            Text("No document loaded.")
        }
    }
}