package com.helloanwar.compose

import android.content.Context
import androidx.compose.remote.core.CoreDocument
import androidx.compose.remote.core.RemoteComposeBuffer
import androidx.compose.remote.creation.CreationDisplayInfo
import androidx.compose.remote.creation.compose.capture.captureSingleRemoteDocument
import androidx.compose.remote.creation.compose.layout.RemoteColumn
import androidx.compose.remote.creation.compose.layout.RemoteText
import androidx.compose.remote.creation.profile.Profile
import androidx.compose.remote.creation.profile.RcPlatformProfiles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayInputStream

object RemoteDocumentProvider {

    suspend fun getRemoteDocument(
        context: Context,
        displayInfo: CreationDisplayInfo,
        profile: Profile = RcPlatformProfiles.ANDROIDX
    ): CoreDocument? {
        return try {
            val bytes = captureSingleRemoteDocument(
                context = context,
                creationDisplayInfo = displayInfo,
                profile = profile
            ) {
                RemoteColumn {
                    RemoteText(text = "Hello from RemoteCompose!")
                    RemoteText(text = "This UI is rendered natively via RemoteCompose.")
                }
            }

            // The captureRemoteDocument function returns the serialized byte array (as Object/Any in signature due to suspend/continuation)
            val byteArray = bytes as ByteArray

            withContext(Dispatchers.Default) {
                val buffer = RemoteComposeBuffer.fromInputStream(ByteArrayInputStream(byteArray))
                val doc = CoreDocument()
                doc.initFromBuffer(buffer)
                doc
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
