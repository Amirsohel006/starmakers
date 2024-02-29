package com.starmakers.app.modules.selectionlistone.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.modules.selectionlistone.`data`.model.Listrectangle107RowModel
import com.starmakers.app.modules.selectionlisttwo.ui.SelectionListTwoActivity
import com.starmakers.app.responses.Data
import com.starmakers.app.responses.SelectionItem
import com.starmakers.app.service.ApiManager
import convertToReadableDate
import kotlin.Int
import kotlin.collections.List

class Listrectangle106Adapter(
  var list: List<SelectionItem>
) : RecyclerView.Adapter<Listrectangle106Adapter.RowListrectangle107VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle107VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle107,parent,false)
    return RowListrectangle107VH(view)
  }

  override fun onBindViewHolder(holder: RowListrectangle107VH, position: Int) {
      return  holder.bindView(list[position])
  }

  override fun getItemCount(): Int {
    return list.size
  }

 fun updateData(newData: List<SelectionItem>) {
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
      item: Listrectangle107RowModel
    ) {
    }
  }

  inner class RowListrectangle107VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {


    val date:TextView=itemView.findViewById(R.id.txtDateOne)
    val venue:TextView=itemView.findViewById(R.id.txtLanguage)
    val position1:TextView=itemView.findViewById(R.id.txtDancer)
    val startTime:TextView=itemView.findViewById(R.id.txtTimeOne)
    val endTime:TextView=itemView.findViewById(R.id.txtTimeTwo)
    val imageView: ImageView =itemView.findViewById(R.id.imageRectangle106)
   val selectionButton: AppCompatButton =itemView.findViewById(R.id.btnSelectionListOne)
    var auditionId:Int=-1
    val moviename:TextView=itemView.findViewById(R.id.movie)


      // Define the corner radius in pixels (converted from dp)
      private val cornerRadiusInPixels = 15 // Change to your dimension resource

      // Create a RequestOptions object with the RoundedCorners transformation
      val requestOptions = RequestOptions()
          .transform(RoundedCorners(cornerRadiusInPixels))

    @SuppressLint("SuspiciousIndentation")
    fun bindView(postModel: SelectionItem) {

        date.text=postModel.applied_date
      venue.text=postModel.audition.venue
      position1.text=postModel.audition.auditions_positions.joinToString { it.audition_positions }
      startTime.text=postModel.audition.timings_from
      endTime.text=postModel.audition.timings_to
      moviename.text=postModel.audition.movie_name
        auditionId=postModel.audition.id

//        Picasso.get()
//            .load(postModel.audition.movie_poster)
//            .into(imageView)

        val image=postModel.audition.movie_poster

        val file=ApiManager.getImageUrl(image)


        Glide.with(itemView)
            .load(image) // Replace with your image URL or resource ID
            .apply(requestOptions)
            .into(imageView)
        selectionButton.setOnClickListener {
            val context = itemView.context
            val intent = Intent(context, SelectionListTwoActivity::class.java)
            intent.putExtra("artistDataId", auditionId) // Pass the id to the new activity
            context.startActivity(intent)
        }
    }
  }
}
