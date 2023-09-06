package com.starmakers.app.modules.artistbookongfour.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListrectangle113Binding
import com.starmakers.app.responses.BookingResponse
import com.starmakers.app.responses.BookingResponseList
import kotlin.Int
import kotlin.collections.List

class Listrectangle113Adapter(
  private var profileDataList: List<BookingResponseList>
) : RecyclerView.Adapter<Listrectangle113Adapter.RowListrectangle114VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle114VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle114,parent,false)
    return RowListrectangle114VH(view)
  }

  override fun onBindViewHolder(holder: RowListrectangle114VH, position: Int) {
    val profileData = profileDataList[position]

    Picasso.get()
      .load(profileData.data.moviePictures[0].picture)
      .into(holder.profilePictureImageView)


    holder.itemView.setOnClickListener {
      clickListener?.onItemClick(it, position, profileData)
    }
  }

  override fun getItemCount(): Int= profileDataList.size
  @SuppressLint("NotifyDataSetChanged")
  fun updateData(newData: List<BookingResponseList>) {
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
      item: BookingResponseList
    ) {
    }
  }

  inner class RowListrectangle114VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
   val profilePictureImageView: ImageView = itemView.findViewById(R.id.imagemovie)

   //   val binding: RowListrectangle113Binding = RowListrectangle113Binding.bind(itemView)
  }
}
