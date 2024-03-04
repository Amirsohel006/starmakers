import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
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

    inner class RowListrectanglenineteenVH(view: View) : RecyclerView.ViewHolder(view) {
        private val exoplayerView: PlayerView = itemView.findViewById(R.id.playerView)
        private val playerContainer: FrameLayout = itemView.findViewById(R.id.playerContainer)

        init {
            exoplayerView.keepScreenOn = true
        }

        fun bindView(postModel: FundingDemoVideos) {
            if (postModel.video.isNullOrBlank()) {
                // Handle the case when uploadVideo is null or empty
                // For example, show an empty state or perform any other action
                exoplayerView.visibility = View.GONE
            } else {
                exoplayerView.visibility = View.VISIBLE

                if (exoPlayer == null) {
                    exoPlayer = SimpleExoPlayer.Builder(context).build()
                    exoplayerView.player = exoPlayer
                }

                val videoUri = postModel.video
                val mediaItem = MediaItem.fromUri(videoUri!!)
                val dataSourceFactory: DefaultDataSourceFactory =
                    DefaultDataSourceFactory(itemView.context, "Exoplayer_Video")
                val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(mediaItem)

                exoPlayer?.setMediaSource(mediaSource)
                exoPlayer?.prepare()
            }
        }

        // Ensure to release the ExoPlayer when the ViewHolder is recycled
        fun releasePlayer() {
            exoPlayer?.stop()
            exoPlayer?.release()
            exoPlayer = null
        }
    }

    override fun onViewRecycled(holder: RowListrectanglenineteenVH) {
        super.onViewRecycled(holder)
        holder.releasePlayer()
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        releasePlayer()
    }

    private fun releasePlayer() {
        exoPlayer?.stop()
        exoPlayer?.release()
        exoPlayer = null
    }
}