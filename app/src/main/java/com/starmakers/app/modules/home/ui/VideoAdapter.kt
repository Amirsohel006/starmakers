package com.starmakers.app.modules.home.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.OptIn
import androidx.annotation.RequiresApi
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.starmakers.app.R
import com.starmakers.app.responses.FundingDemoVideos

class VideoAdapter(
    private val context: Context,
    var list: List<FundingDemoVideos>
) : RecyclerView.Adapter<VideoAdapter.RowListrectanglenineteenVH>() {
    private var clickListener: OnItemClickListener? = null
    private var exoPlayer: SimpleExoPlayer = SimpleExoPlayer.Builder(context).build()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectanglenineteenVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_video_funding_demo, parent, false)
        return RowListrectanglenineteenVH(view)
    }

    override fun onBindViewHolder(holder: RowListrectanglenineteenVH, position: Int) {
        holder.bindView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateData(newData: List<FundingDemoVideos>) {
        list = newData
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(clickListener: OnItemClickListener) {
        this.clickListener = clickListener
    }

    interface OnItemClickListener {
        fun onItemClick(
            view: View,
            position: Int,
            item: FundingDemoVideos
        )
    }

    inner class RowListrectanglenineteenVH(view: View) : RecyclerView.ViewHolder(view) {
        val exoplayerView: PlayerView = itemView.findViewById(R.id.playerView)

        init {
            exoplayerView.player = exoPlayer
        }

        fun bindView(postModel: FundingDemoVideos) {
            if (postModel.video.isNullOrBlank()) {
                // Handle the case when uploadVideo is null or empty
                // For example, show an empty state or perform any other action
                exoplayerView.visibility = View.GONE
            } else {
                val videoUri = postModel.video
                val mediaItem = MediaItem.fromUri(videoUri!!)
                val dataSourceFactory: DefaultDataSourceFactory =
                    DefaultDataSourceFactory(itemView.context, "Exoplayer_Video")
                val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(mediaItem)

                exoPlayer.setMediaSource(mediaSource)
                exoPlayer.prepare()
            }
        }
    }
}

