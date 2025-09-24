package com.example.lab13_voytovych.video

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class VideoPlayerManager(private val context: Context) {

    private lateinit var exoPlayer: ExoPlayer
    private var isFullScreen by mutableStateOf(false)

    init {
        initializePlayer()
    }

    private fun initializePlayer() {
        exoPlayer = ExoPlayer.Builder(context).build()
    }

    fun playVideo(videoUrl: String) {
        val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    fun toggleFullScreen() {
        isFullScreen = !isFullScreen
    }

    fun release() {
        exoPlayer.release()
    }

    fun getPlayerView(): PlayerView {
        val playerView = PlayerView(context)
        playerView.player = exoPlayer
        return playerView
    }
}