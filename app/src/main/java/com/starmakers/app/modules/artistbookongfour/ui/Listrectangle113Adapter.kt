package com.starmakers.app.modules.artistbookongfour.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListrectangle114Binding
import com.starmakers.app.modules.artistbookongfour.`data`.model.Listrectangle114RowModel
import kotlin.Int
import kotlin.collections.List

class Listrectangle113Adapter(
  var list: List<Listrectangle114RowModel>
) : RecyclerView.Adapter<Listrectangle113Adapter.RowListrectangle114VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle114VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle114,parent,false)
    return RowListrectangle114VH(view)
  }

  override fun onBindViewHolder(holder: RowListrectangle114VH, position: Int) {
    val listrectangle114RowModel = Listrectangle114RowModel()
    // TODO uncomment following line after integration with data source
    // val listrectangle114RowModel = list[position]
    holder.binding.listrectangle114RowModel = listrectangle114RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listrectangle114RowModel>) {
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
      item: Listrectangle114RowModel
    ) {
    }
  }

  inner class RowListrectangle114VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListrectangle114Binding = RowListrectangle114Binding.bind(itemView)
  }
}
