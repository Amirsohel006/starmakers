package com.starmakers.app.modules.auditions.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.modules.auditions.`data`.model.AuditionsRowModel
import com.starmakers.app.modules.auditionsfour.ui.AuditionsFourActivity
import com.starmakers.app.modules.campaign.ui.CampaignActivity
import com.starmakers.app.responses.AuditionsPosition
import com.starmakers.app.responses.Data
import com.starmakers.app.service.ApiManager
import kotlin.Int
import kotlin.collections.List

class AuditionsAdapter(
  var list: List<Data>
) : RecyclerView.Adapter<AuditionsAdapter.RowAuditionsVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowAuditionsVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_auditions,parent,false)
    return RowAuditionsVH(view)
  }

  override fun onBindViewHolder(holder: RowAuditionsVH, position: Int) {
    return  holder.bindView(list[position])
  }

  override fun getItemCount(): Int {
    return list.size
  }


   fun updateData(newData: List<Data>) {
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
      item: AuditionsRowModel
    ) {
    }
  }

  inner class RowAuditionsVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
   // val binding: RowAuditionsBinding = RowAuditionsBinding.bind(itemView)

    val date:TextView=itemView.findViewById(R.id.txtDateOne)
    val venue:TextView=itemView.findViewById(R.id.txtLanguage)
    val position1:TextView=itemView.findViewById(R.id.txtDancerActor)
    val startTime:TextView=itemView.findViewById(R.id.txtTimeOne)
    val endTime:TextView=itemView.findViewById(R.id.txtTimeTwo)
    val imageView:ImageView=itemView.findViewById(R.id.imageRectangle106)
    val participateButton:AppCompatButton=itemView.findViewById(R.id.btnParticipate)
    var auditionId:Int=-1
    val moviename:TextView=itemView.findViewById(R.id.movie)


    val layout:LinearLayout=itemView.findViewById(R.id.linearRowrectangle106)

    // Define the corner radius in pixels (converted from dp)
    private val cornerRadiusInPixels = 15 // Change to your dimension resource

    // Create a RequestOptions object with the RoundedCorners transformation
    val requestOptions = RequestOptions()
      .transform(RoundedCorners(cornerRadiusInPixels))
    fun bindView(postModel: Data) {
      date.text=postModel.audition_date
      venue.text=postModel.venue
      val auditionPositions = postModel.auditions_positions.joinToString { it.audition_positions }
      position1.text = auditionPositions
      startTime.text=postModel.timings_from
      endTime.text=postModel.timings_to

      auditionId=postModel.id
      moviename.text=postModel.movie_name

//      Picasso.get()
//        .load(postModel.movie_poster)
//        .into(imageView)

      val image=postModel.movie_poster

      val file=ApiManager.getImageUrl(image)

      Glide.with(itemView)
        .load(file) // Replace with your image URL or resource ID
        .apply(requestOptions)
        .into(imageView)

      participateButton.setOnClickListener {
        val context = itemView.context
        val intent = Intent(context, AuditionsFourActivity::class.java)
        intent.putExtra("artistDataId", auditionId) // Pass the id to the new activity
        context.startActivity(intent)
      }


      layout.setOnClickListener {
        val context = itemView.context
        val intent = Intent(context, CampaignActivity::class.java)
        intent.putExtra("poster", file)
        intent.putExtra("movie_name",postModel.movie_name)
        intent.putExtra("venue",postModel.venue)
        intent.putExtra("audtion_date",postModel.audition_date)
        intent.putExtra("start_time",postModel.timings_from)
        intent.putExtra("end_time",postModel.timings_to)
        intent.putExtra("storyline",postModel.story_line)
        intent.putExtra("artistDataId", auditionId)

        context.startActivity(intent)
      }
      imageView.setOnClickListener {
        val context = itemView.context
        val intent = Intent(context, CampaignActivity::class.java)
        intent.putExtra("poster", file)
        intent.putExtra("movie_name",postModel.movie_name)
        intent.putExtra("venue",postModel.venue)
        intent.putExtra("audtion_date",postModel.audition_date)
        intent.putExtra("start_time",postModel.timings_from)
        intent.putExtra("end_time",postModel.timings_to)
        intent.putExtra("storyline",postModel.story_line)
        intent.putExtra("artistDataId", auditionId)

        context.startActivity(intent)
      }


    }
  }
}
