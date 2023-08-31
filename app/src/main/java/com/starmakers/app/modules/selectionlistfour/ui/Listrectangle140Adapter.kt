package com.starmakers.app.modules.selectionlistfour.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListrectangle140Binding
import com.starmakers.app.modules.selectionlistfour.`data`.model.Listrectangle140RowModel
import kotlin.Int
import kotlin.collections.List

class Listrectangle140Adapter(
  var list: List<Listrectangle140RowModel>
) : RecyclerView.Adapter<Listrectangle140Adapter.RowListrectangle140VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle140VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle140,parent,false)
    return RowListrectangle140VH(view)
  }

  override fun onBindViewHolder(holder: RowListrectangle140VH, position: Int) {
    val listrectangle140RowModel = Listrectangle140RowModel()
    // TODO uncomment following line after integration with data source
    // val listrectangle140RowModel = list[position]
    holder.binding.listrectangle140RowModel = listrectangle140RowModel
  }

  override fun getItemCount(): Int = 5
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listrectangle140RowModel>) {
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
      item: Listrectangle140RowModel
    ) {
    }
  }

  inner class RowListrectangle140VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListrectangle140Binding = RowListrectangle140Binding.bind(itemView)
  }
}
