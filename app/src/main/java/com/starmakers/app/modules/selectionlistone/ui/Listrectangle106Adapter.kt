package com.starmakers.app.modules.selectionlistone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListrectangle107Binding
import com.starmakers.app.modules.selectionlistone.`data`.model.Listrectangle107RowModel
import kotlin.Int
import kotlin.collections.List

class Listrectangle106Adapter(
  var list: List<Listrectangle107RowModel>
) : RecyclerView.Adapter<Listrectangle106Adapter.RowListrectangle107VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle107VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle107,parent,false)
    return RowListrectangle107VH(view)
  }

  override fun onBindViewHolder(holder: RowListrectangle107VH, position: Int) {
    val listrectangle107RowModel = Listrectangle107RowModel()
    // TODO uncomment following line after integration with data source
    // val listrectangle107RowModel = list[position]
    holder.binding.listrectangle107RowModel = listrectangle107RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listrectangle107RowModel>) {
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
      item: Listrectangle107RowModel
    ) {
    }
  }

  inner class RowListrectangle107VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListrectangle107Binding = RowListrectangle107Binding.bind(itemView)
    init {
      binding.btnSelectionListOne.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, Listrectangle107RowModel())
      }
    }
  }
}
