package com.starmakers.app.modules.selectionlisttwo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListrectangle141Binding
import com.starmakers.app.modules.selectionlisttwo.`data`.model.Listrectangle141RowModel
import kotlin.Int
import kotlin.collections.List

class Listrectangle140Adapter(
  var list: List<Listrectangle141RowModel>
) : RecyclerView.Adapter<Listrectangle140Adapter.RowListrectangle141VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle141VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle141,parent,false)
    return RowListrectangle141VH(view)
  }

  override fun onBindViewHolder(holder: RowListrectangle141VH, position: Int) {
    val listrectangle141RowModel = Listrectangle141RowModel()
    // TODO uncomment following line after integration with data source
    // val listrectangle141RowModel = list[position]
    holder.binding.listrectangle141RowModel = listrectangle141RowModel
  }

  override fun getItemCount(): Int = 5
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listrectangle141RowModel>) {
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
    val binding: RowListrectangle141Binding = RowListrectangle141Binding.bind(itemView)
  }
}
