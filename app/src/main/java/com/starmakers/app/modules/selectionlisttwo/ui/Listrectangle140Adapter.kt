package com.starmakers.app.modules.selectionlisttwo.ui

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.modules.selectionlisttwo.`data`.model.Listrectangle141RowModel
import com.starmakers.app.responses.SelectionListArtist
import com.starmakers.app.service.ApiManager
import java.io.File
import kotlin.Int
import kotlin.collections.List

class Listrectangle140Adapter(
  var list: List<SelectionListArtist?>
) : RecyclerView.Adapter<Listrectangle140Adapter.RowListrectangle141VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle141VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle141,parent,false)
    return RowListrectangle141VH(view)
  }

  override fun onBindViewHolder(holder: RowListrectangle141VH, position: Int) {
    return list[position].let {
      if (it != null) {
        holder.bindView(it)
      }
    }
  }

  override fun getItemCount(): Int{
    return list.size
  }
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<SelectionListArtist>) {
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
      item: Listrectangle141RowModel
    ) {
    }
  }

  inner class RowListrectangle141VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
   // val binding: RowListrectangle141Binding = RowListrectangle141Binding.bind(itemView)

    val nameChandru:TextView=itemView.findViewById(R.id.txtChandru)
    val age:TextView=itemView.findViewById(R.id.txtYrsCounter)
    val image:ImageView=itemView.findViewById(R.id.imageRectangle140)
   val location:TextView=itemView.findViewById(R.id.txtBangalore)


    // Define the corner radius in pixels (converted from dp)
    val cornerRadiusInPixels = 15 // Change to your dimension resource

    // Create a RequestOptions object with the RoundedCorners transformation
    val requestOptions = RequestOptions()
      .transform(RoundedCorners(cornerRadiusInPixels))

    fun bindView(postModel: SelectionListArtist){
      nameChandru.text=postModel.name
      age.text=postModel.age
      //val file = postModel.profile
      location.text=postModel.location?:""


      val imageUrl = postModel.artistPictures.getOrNull(0)?.artistPicture

      if (!imageUrl.isNullOrEmpty()) {
        val file = ApiManager.getImageUrl(imageUrl)
        // Use the file as needed
        Glide.with(itemView)
          .load(file) // Replace with your image URL or resource ID
          .apply(requestOptions)
          .into(image)
      } else {
        // Handle the case when imageUrl is null or empty
        // For example, set a placeholder image or hide the ImageView
        // imageView.setImageResource(R.drawable.placeholder)
        // image.visibility = View.GONE
      }

//      Picasso.get()
//        .load(imgUrl)
//        .into(image)







    }

  }
}
