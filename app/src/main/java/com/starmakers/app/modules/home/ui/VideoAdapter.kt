import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
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

        private val orientationIcon:ImageView=itemView.findViewById(R.id.orientationIcon)

        private val playerContainer:FrameLayout=itemView.findViewById(R.id.playerContainer)


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
                // bandwidthmeter is used for
                // getting default bandwidth
                val context = itemView.context






                if (isNetworkAvailable(context)) {
                    val bandwidthMeter: BandwidthMeter = DefaultBandwidthMeter()

                    // track selector is used to navigate between
                    // video using a default seekbar.
                    val trackSelector: TrackSelector =
                        DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandwidthMeter))

                    // we are adding our track selector to exoplayer.
                    exoPlayer = ExoPlayerFactory.newSimpleInstance(itemView.context, trackSelector)

                    // we are parsing a video url
                    // and parsing its video uri.
                    val videoURI: Uri = Uri.parse(videoUri)

                    val dataSourceFactory = DefaultHttpDataSourceFactory(
                        "Exoplayer_video", null,
                        DefaultHttpDataSource.DEFAULT_CONNECT_TIMEOUT_MILLIS,
                        DefaultHttpDataSource.DEFAULT_READ_TIMEOUT_MILLIS, true
                    )


                    // we are creating a variable for extractor factory
                    // and setting it to default extractor factory.
                    val extractorsFactory: ExtractorsFactory = DefaultExtractorsFactory();

                    // we are creating a media source with above variables
                    // and passing our event handler as null,
                    val mediaSourse: MediaSource =
                        ExtractorMediaSource(
                            videoURI,
                            dataSourceFactory,
                            extractorsFactory,
                            null,
                            null
                        )

                    // inside our exoplayer view
                    // we are setting our player
                    exoplayerView.player = exoPlayer

                    // we are preparing our exoplayer
                    // with media source.
                    exoPlayer?.prepare(mediaSourse)

                    // we are setting our exoplayer
                    // when it is ready.
                    exoPlayer?.playWhenReady = false
                }
            }

            orientationIcon.setOnClickListener {
                val params = exoplayerView.layoutParams as FrameLayout.LayoutParams
                params.width = ViewGroup.LayoutParams.MATCH_PARENT
                params.height = ViewGroup.LayoutParams.MATCH_PARENT
                exoplayerView.layoutParams = params
                exoplayerView.parent?.requestLayout()
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
