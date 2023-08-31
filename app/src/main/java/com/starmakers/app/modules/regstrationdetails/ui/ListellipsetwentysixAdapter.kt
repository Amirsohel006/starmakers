package com.starmakers.app.modules.regstrationdetails.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListellipsetwentysix2Binding
import com.starmakers.app.modules.regstrationdetails.`data`.model.Listellipsetwentysix2RowModel
import kotlin.Int
import kotlin.collections.List

class ListellipsetwentysixAdapter(
  var list: List<Listellipsetwentysix2RowModel>
) : RecyclerView.Adapter<ListellipsetwentysixAdapter.RowListellipsetwentysix2VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListellipsetwentysix2VH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listellipsetwentysix2,parent,false)
    return RowListellipsetwentysix2VH(view)
  }

  override fun onBindViewHolder(holder: RowListellipsetwentysix2VH, position: Int) {
    val listellipsetwentysix2RowModel = Listellipsetwentysix2RowModel()
    // TODO uncomment following line after integration with data source
    // val listellipsetwentysix2RowModel = list[position]
    holder.binding.listellipsetwentysix2RowModel = listellipsetwentysix2RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listellipsetwentysix2RowModel>) {
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
      item: Listellipsetwentysix2RowModel
    ) {
    }
  }

  inner class RowListellipsetwentysix2VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListellipsetwentysix2Binding = RowListellipsetwentysix2Binding.bind(itemView)
  }
}
