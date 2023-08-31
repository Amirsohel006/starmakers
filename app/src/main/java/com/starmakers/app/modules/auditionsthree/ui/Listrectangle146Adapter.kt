package com.starmakers.app.modules.auditionsthree.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListrectangle146Binding
import com.starmakers.app.modules.auditionsthree.`data`.model.Listrectangle146RowModel
import kotlin.Int
import kotlin.collections.List

class Listrectangle146Adapter(
  var list: List<Listrectangle146RowModel>
) : RecyclerView.Adapter<Listrectangle146Adapter.RowListrectangle146VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle146VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle146,parent,false)
    return RowListrectangle146VH(view)
  }

  override fun onBindViewHolder(holder: RowListrectangle146VH, position: Int) {
    val listrectangle146RowModel = Listrectangle146RowModel()
    // TODO uncomment following line after integration with data source
    // val listrectangle146RowModel = list[position]
    holder.binding.listrectangle146RowModel = listrectangle146RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listrectangle146RowModel>) {
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
      item: Listrectangle146RowModel
    ) {
    }
  }

  inner class RowListrectangle146VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListrectangle146Binding = RowListrectangle146Binding.bind(itemView)
  }
}
