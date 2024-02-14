package com.starmakers.app.modules.artistbookongfour.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.responses.BookingMoviePicture
import com.starmakers.app.service.ApiManager
import kotlin.Int

class Listrectangle113Adapter(
  private var profileDataList: ArrayList<BookingMoviePicture>
) : RecyclerView.Adapter<Listrectangle113Adapter.RowListrectangle114VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle114VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle114,parent,false)
    return RowListrectangle114VH(view)
  }

  override fun getItemCount(): Int{
     return  profileDataList.size
  }
  @SuppressLint("SuspiciousIndentation")
  override fun onBindViewHolder(holder: RowListrectangle114VH, position: Int) {
    return  holder.bindView(profileDataList[position])
  }


  @SuppressLint("NotifyDataSetChanged")
  fun updateData(newData: ArrayList<BookingMoviePicture>) {
    profileDataList = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: BookingMoviePicture
    ) {
    }
  }

  inner class RowListrectangle114VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val profilePictureImageView: ImageView = itemView.findViewById(R.id.imagemovie)

    // Define the corner radius in pixels (converted from dp)
    val cornerRadiusInPixels = 15 // Change to your dimension resource

    // Create a RequestOptions object with the RoundedCorners transformation
    val requestOptions = RequestOptions()
      .transform(RoundedCorners(cornerRadiusInPixels))

    fun bindView(postModel: BookingMoviePicture) {

//      Picasso.get()
//        .load(postModel.picture)
//        .into(profilePictureImageView)

      val image=postModel.picture

      val file=ApiManager.getImageUrl(image!!)

      Glide.with(itemView)
        .load(file) // Replace with your image URL or resource ID
        .apply(requestOptions)
        .into(profilePictureImageView)
    }
  }
}