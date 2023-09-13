package com.starmakers.app.modules.selectionlisttwo.ui

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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
   // val location:TextView=itemView.findViewById(R.id.txtBangalore)


    fun bindView(postModel: SelectionListArtist){
      nameChandru.text=postModel.name
      age.text=postModel.age
      val file = postModel.profile // Assuming postModel.profile is a File object

      val imgUrl= file?.let { ApiManager.getImageUrl(it) }

      Picasso.get()
        .load(imgUrl)
        .into(image)




      if (imgUrl != null) {
        Log.d("importfile",imgUrl)
      }
    }

  }
}
