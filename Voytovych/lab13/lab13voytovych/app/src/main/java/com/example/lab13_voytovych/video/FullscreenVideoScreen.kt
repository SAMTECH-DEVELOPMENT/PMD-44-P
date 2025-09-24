package com.example.lab13_voytovych.video

import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.lab13_voytovych.video.VideoPlayerManager

@Composable
fun FullscreenVideoScreen(videoUrl: String) {
    val context = LocalContext.current
    val view = LocalView.current

    val videoPlayerManager = remember { VideoPlayerManager(context) }

    var isFullScreen by remember { mutableStateOf(false) }

    DisposableEffect(videoPlayerManager) {
        try {
            videoPlayerManager.playVideo(videoUrl)
        } catch (e: Exception) {
            println("Error playing video: ${e.message}")
        }
        onDispose { videoPlayerManager.release() }
    }

    DisposableEffect(isFullScreen) {
        val activity = context as? android.app.Activity ?: return@DisposableEffect onDispose {}

        if (isFullScreen) {
            // Перевернути в ландшафтний режим
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            WindowCompat.setDecorFitsSystemWindows(activity.window, false)
            WindowInsetsControllerCompat(activity.window, view).apply {
                hide(3) // STATUS_BARS | NAVIGATION_BAR
                systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            // Повернути в автоматичний режим
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
            WindowCompat.setDecorFitsSystemWindows(activity.window, true)
            WindowInsetsControllerCompat(activity.window, view).show(3)
        }

        onDispose { }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            factory = { videoPlayerManager.getPlayerView() },
            modifier = Modifier.fillMaxSize()
        )

        Button(
            onClick = {
                isFullScreen = !isFullScreen
                videoPlayerManager.toggleFullScreen()
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text(text = if (isFullScreen) "Exit Fullscreen" else "Enter Fullscreen")
        }
    }
}