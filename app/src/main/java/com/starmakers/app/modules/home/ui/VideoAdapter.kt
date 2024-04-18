import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.media3.common.Player
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.starmakers.app.R
import com.starmakers.app.modules.videoplayeractivity.VideoPlayerActivity
import com.starmakers.app.responses.FundingDemoVideos

class VideoAdapter(
    private val context: Context,
    private var list: List<FundingDemoVideos>
) : RecyclerView.Adapter<VideoAdapter.RowListrectanglenineteenVH>() {

    private var exoPlayer: SimpleExoPlayer? = null




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectanglenineteenVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_video_funding_demo, parent, false)
        return RowListrectanglenineteenVH(view, context as Activity)
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

    inner class RowListrectanglenineteenVH(view: View, private val activity: Activity) : RecyclerView.ViewHolder(view) {
        private val exoplayerView: SimpleExoPlayerView = itemView.findViewById(R.id.playerView)
        private val orientationIcon: ImageView = itemView.findViewById(R.id.orientationIcon)
        private val playerContainer: FrameLayout = itemView.findViewById(R.id.playerContainer)


        init {
            // Initialize ExoPlayer in the constructor
            val bandwidthMeter: BandwidthMeter = DefaultBandwidthMeter()
            val trackSelector: TrackSelector =
                DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandwidthMeter))
            exoPlayer = ExoPlayerFactory.newSimpleInstance(itemView.context, trackSelector)



        }

        fun bindView(postModel: FundingDemoVideos) {
            if (postModel.video.isNullOrBlank()) {
                // Handle the case when uploadVideo is null or empty
                // For example, show an empty state or perform any other action
                exoplayerView.visibility = View.GONE
            } else {
                val videoUri = postModel.video!!
                val context = itemView.context

                if (isNetworkAvailable(context)) {
                    val bandwidthMeter: BandwidthMeter = DefaultBandwidthMeter()
                    val trackSelector: TrackSelector =
                        DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandwidthMeter))
                    exoPlayer = ExoPlayerFactory.newSimpleInstance(itemView.context, trackSelector)

                    val videoURI: Uri = Uri.parse(videoUri)

                    val dataSourceFactory = DefaultHttpDataSourceFactory(
                        "Exoplayer_video", null,
                        DefaultHttpDataSource.DEFAULT_CONNECT_TIMEOUT_MILLIS,
                        DefaultHttpDataSource.DEFAULT_READ_TIMEOUT_MILLIS, true
                    )

                    val extractorsFactory: ExtractorsFactory = DefaultExtractorsFactory()

                    val mediaSourse: MediaSource =
                        ExtractorMediaSource(
                            videoURI,
                            dataSourceFactory,
                            extractorsFactory,
                            null,
                            null
                        )

                    exoplayerView.player = exoPlayer
                    exoPlayer?.prepare(mediaSourse)
                    exoPlayer?.playWhenReady = false
                }
            }

             orientationIcon.setOnClickListener {
                val intent = Intent(activity, VideoPlayerActivity::class.java)
                intent.putExtra("videoUrl", postModel.video)
                activity.startActivity(intent)
            }
        }



        init {
            exoplayerView.setOnClickListener {
                exoPlayer?.playWhenReady = true
            }
        }

        private fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }


    }


}
