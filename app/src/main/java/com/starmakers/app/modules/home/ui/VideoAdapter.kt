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
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.starmakers.app.R
import com.starmakers.app.modules.studiobookongone.data.model.ListrectanglenineteenRowModel
import com.starmakers.app.responses.FundingDemoVideos
import com.starmakers.app.responses.Studio


class VideoAdapter(
    var list:  List<FundingDemoVideos>
) : RecyclerView.Adapter<VideoAdapter.RowListrectanglenineteenVH>() {
    private var clickListener: OnItemClickListener? = null


   // private lateinit var connectivityManager: ConnectivityManager

    lateinit var exoPlayer: SimpleExoPlayer

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoAdapter.RowListrectanglenineteenVH {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.row_video_funding_demo,parent,false)
        return RowListrectanglenineteenVH(view)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: VideoAdapter.RowListrectanglenineteenVH, position: Int) {
        return  holder.bindView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    public fun updateData(newData: List<FundingDemoVideos>) {
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
            item: ListrectanglenineteenRowModel
        ) {
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    inner class RowListrectanglenineteenVH(view: View) : RecyclerView.ViewHolder(view) {
        val exoplayerView: PlayerView = itemView.findViewById(R.id.playerView)




        fun bindView(postModel: FundingDemoVideos) {
            if (postModel.video.isNullOrBlank()) {
                // Handle the case when uploadVideo is null or empty
                // For example, show an empty state or perform any other action
                exoplayerView.visibility = View.GONE
            } else {
                val videoUri = postModel.video!!

                Log.d("Video Editor",videoUri.toString())
                // val bandwidthMeter: BandwidthMeter = DefaultBandwidthMeter()
                val trackSelector: TrackSelector = DefaultTrackSelector(itemView.context, AdaptiveTrackSelection.Factory())
                exoPlayer = SimpleExoPlayer.Builder(itemView.context).setTrackSelector(trackSelector).build()

                val mediaItem = MediaItem.fromUri(videoUri)

                val dataSourceFactory: DefaultDataSourceFactory =
                    DefaultDataSourceFactory(itemView.context, "Exoplayer_Video")

                val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(mediaItem)

                exoplayerView.player = exoPlayer

                exoPlayer.setMediaSource(mediaSource)
                exoPlayer.prepare()
            }






        }




    }




}
