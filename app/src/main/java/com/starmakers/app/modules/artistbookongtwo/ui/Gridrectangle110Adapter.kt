package com.starmakers.app.modules.artistbookongtwo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowGridrectangle110Binding
import com.starmakers.app.modules.artistbookongtwo.`data`.model.Gridrectangle110RowModel
import kotlin.Int
import kotlin.collections.List

class Gridrectangle110Adapter(
  var list: List<Gridrectangle110RowModel>
) : RecyclerView.Adapter<Gridrectangle110Adapter.RowGridrectangle110VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowGridrectangle110VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_gridrectangle110,parent,false)
    return RowGridrectangle110VH(view)
  }

  override fun onBindViewHolder(holder: RowGridrectangle110VH, position: Int) {
    val gridrectangle110RowModel = Gridrectangle110RowModel()
    // TODO uncomment following line after integration with data source
    // val gridrectangle110RowModel = list[position]
    holder.binding.gridrectangle110RowModel = gridrectangle110RowModel
  }

  override fun getItemCount(): Int = 18
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Gridrectangle110RowModel>) {
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
      item: Gridrectangle110RowModel
    ) {
    }
  }

  inner class RowGridrectangle110VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowGridrectangle110Binding = RowGridrectangle110Binding.bind(itemView)
    init {
      binding.imageRectangle110.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, Gridrectangle110RowModel())
      }
    }
  }
}
