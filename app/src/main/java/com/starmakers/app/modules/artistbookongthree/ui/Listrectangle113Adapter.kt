package com.starmakers.app.modules.artistbookongthree.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListrectangle113Binding
import com.starmakers.app.modules.artistbookongthree.`data`.model.Listrectangle113RowModel
import kotlin.Int
import kotlin.collections.List

class Listrectangle113Adapter(
  var list: List<Listrectangle113RowModel>
) : RecyclerView.Adapter<Listrectangle113Adapter.RowListrectangle113VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle113VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle113,parent,false)
    return RowListrectangle113VH(view)
  }

  override fun onBindViewHolder(holder: RowListrectangle113VH, position: Int) {
    val listrectangle113RowModel = Listrectangle113RowModel()
    // TODO uncomment following line after integration with data source
    // val listrectangle113RowModel = list[position]
    holder.binding.listrectangle113RowModel = listrectangle113RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listrectangle113RowModel>) {
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
      item: Listrectangle113RowModel
    ) {
    }
  }

  inner class RowListrectangle113VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListrectangle113Binding = RowListrectangle113Binding.bind(itemView)
  }
}
