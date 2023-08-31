package com.starmakers.app.modules.paymentpage.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListpaypaloneBinding
import com.starmakers.app.modules.paymentpage.`data`.model.ListpaypaloneRowModel
import kotlin.Int
import kotlin.collections.List

class ListpaypaloneAdapter(
  var list: List<ListpaypaloneRowModel>
) : RecyclerView.Adapter<ListpaypaloneAdapter.RowListpaypaloneVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListpaypaloneVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listpaypalone,parent,false)
    return RowListpaypaloneVH(view)
  }

  override fun onBindViewHolder(holder: RowListpaypaloneVH, position: Int) {
    val listpaypaloneRowModel = ListpaypaloneRowModel()
    // TODO uncomment following line after integration with data source
    // val listpaypaloneRowModel = list[position]
    holder.binding.listpaypaloneRowModel = listpaypaloneRowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListpaypaloneRowModel>) {
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
      item: ListpaypaloneRowModel
    ) {
    }
  }

  inner class RowListpaypaloneVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListpaypaloneBinding = RowListpaypaloneBinding.bind(itemView)
  }
}
