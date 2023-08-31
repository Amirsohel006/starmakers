package com.starmakers.app.modules.financialoverview.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowGridrectangletenBinding
import com.starmakers.app.modules.financialoverview.`data`.model.GridrectangletenRowModel
import kotlin.Int
import kotlin.collections.List

class GridrectangletenAdapter(
  var list: List<GridrectangletenRowModel>
) : RecyclerView.Adapter<GridrectangletenAdapter.RowGridrectangletenVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowGridrectangletenVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_gridrectangleten,parent,false)
    return RowGridrectangletenVH(view)
  }

  override fun onBindViewHolder(holder: RowGridrectangletenVH, position: Int) {
    val gridrectangletenRowModel = GridrectangletenRowModel()
    // TODO uncomment following line after integration with data source
    // val gridrectangletenRowModel = list[position]
    holder.binding.gridrectangletenRowModel = gridrectangletenRowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<GridrectangletenRowModel>) {
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
      item: GridrectangletenRowModel
    ) {
    }
  }

  inner class RowGridrectangletenVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowGridrectangletenBinding = RowGridrectangletenBinding.bind(itemView)
    init {
      binding.linearRowviewdetails.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, GridrectangletenRowModel())
      }
    }
  }
}
