package com.starmakers.app.modules.auditionstwo.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.databinding.RowAuditionsTwoBinding
import com.starmakers.app.modules.auditionstwo.`data`.model.AuditionsTwoRowModel
import com.starmakers.app.responses.MyStudioMovie
import com.starmakers.app.responses.MyStudioPicture
import com.starmakers.app.service.ApiManager
import kotlin.Int
import kotlin.collections.List

class AuditionsTwoAdapter(
  var list: List<MyStudioMovie>
) : RecyclerView.Adapter<AuditionsTwoAdapter.RowAuditionsTwoVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowAuditionsTwoVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_auditions_two,parent,false)
    return RowAuditionsTwoVH(view)
  }

  override fun onBindViewHolder(holder: RowAuditionsTwoVH, position: Int) {
    return  holder.bindView(list[position])
  }

  override fun getItemCount(): Int {
    return  list.size
  }

  @SuppressLint("NotifyDataSetChanged")
  public fun updateData(newData: List<MyStudioMovie>) {
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
      item: AuditionsTwoRowModel
    ) {
    }
  }

  inner class RowAuditionsTwoVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowAuditionsTwoBinding = RowAuditionsTwoBinding.bind(itemView)

    val image:ImageView=itemView.findViewById(R.id.imageRectangle113)
    fun bindView(postmodel:MyStudioMovie){
      val file=postmodel.studio_movie
      val imgUrl= file.let { ApiManager.getImageUrl(it) }
      Picasso.get().load(imgUrl).into(image)
    }
  }
}
