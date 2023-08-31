package com.starmakers.app.modules.artistmembershiptwo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListellipsetwentysix1Binding
import com.starmakers.app.modules.artistmembershiptwo.`data`.model.Listellipsetwentysix1RowModel
import kotlin.Int
import kotlin.collections.List

class ListellipsetwentysixAdapter(
  var list: List<Listellipsetwentysix1RowModel>
) : RecyclerView.Adapter<ListellipsetwentysixAdapter.RowListellipsetwentysix1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListellipsetwentysix1VH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listellipsetwentysix1,parent,false)
    return RowListellipsetwentysix1VH(view)
  }

  override fun onBindViewHolder(holder: RowListellipsetwentysix1VH, position: Int) {
    val listellipsetwentysix1RowModel = Listellipsetwentysix1RowModel()
    // TODO uncomment following line after integration with data source
    // val listellipsetwentysix1RowModel = list[position]
    holder.binding.listellipsetwentysix1RowModel = listellipsetwentysix1RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listellipsetwentysix1RowModel>) {
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
      item: Listellipsetwentysix1RowModel
    ) {
    }
  }

  inner class RowListellipsetwentysix1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListellipsetwentysix1Binding = RowListellipsetwentysix1Binding.bind(itemView)
  }
}
