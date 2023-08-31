package com.starmakers.app.modules.paymentpage.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListellipsetwentysixBinding
import com.starmakers.app.modules.paymentpage.`data`.model.ListellipsetwentysixRowModel
import kotlin.Int
import kotlin.collections.List

class ListellipsetwentysixAdapter(
  var list: List<ListellipsetwentysixRowModel>
) : RecyclerView.Adapter<ListellipsetwentysixAdapter.RowListellipsetwentysixVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListellipsetwentysixVH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listellipsetwentysix,parent,false)
    return RowListellipsetwentysixVH(view)
  }

  override fun onBindViewHolder(holder: RowListellipsetwentysixVH, position: Int) {
    val listellipsetwentysixRowModel = ListellipsetwentysixRowModel()
    // TODO uncomment following line after integration with data source
    // val listellipsetwentysixRowModel = list[position]
    holder.binding.listellipsetwentysixRowModel = listellipsetwentysixRowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListellipsetwentysixRowModel>) {
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
      item: ListellipsetwentysixRowModel
    ) {
    }
  }

  inner class RowListellipsetwentysixVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListellipsetwentysixBinding = RowListellipsetwentysixBinding.bind(itemView)
  }
}
