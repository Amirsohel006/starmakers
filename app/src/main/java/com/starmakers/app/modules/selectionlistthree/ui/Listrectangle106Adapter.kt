package com.starmakers.app.modules.selectionlistthree.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListrectangle106Binding
import com.starmakers.app.modules.selectionlistthree.`data`.model.Listrectangle106RowModel
import kotlin.Int
import kotlin.collections.List

class Listrectangle106Adapter(
  var list: List<Listrectangle106RowModel>
) : RecyclerView.Adapter<Listrectangle106Adapter.RowListrectangle106VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle106VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle106,parent,false)
    return RowListrectangle106VH(view)
  }

  override fun onBindViewHolder(holder: RowListrectangle106VH, position: Int) {
    val listrectangle106RowModel = Listrectangle106RowModel()
    // TODO uncomment following line after integration with data source
    // val listrectangle106RowModel = list[position]
    holder.binding.listrectangle106RowModel = listrectangle106RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listrectangle106RowModel>) {
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
      item: Listrectangle106RowModel
    ) {
    }
  }

  inner class RowListrectangle106VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListrectangle106Binding = RowListrectangle106Binding.bind(itemView)
    init {
      binding.btnSelectionList.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, Listrectangle106RowModel())
      }
    }
  }
}
