package com.starmakers.app.modules.artistmembershiptwo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListpaypalone1Binding
import com.starmakers.app.modules.artistmembershiptwo.`data`.model.Listpaypalone1RowModel
import kotlin.Int
import kotlin.collections.List

class ListpaypaloneAdapter(
  var list: List<Listpaypalone1RowModel>
) : RecyclerView.Adapter<ListpaypaloneAdapter.RowListpaypalone1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListpaypalone1VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listpaypalone1,parent,false)
    return RowListpaypalone1VH(view)
  }

  override fun onBindViewHolder(holder: RowListpaypalone1VH, position: Int) {
    val listpaypalone1RowModel = Listpaypalone1RowModel()
    // TODO uncomment following line after integration with data source
    // val listpaypalone1RowModel = list[position]
    holder.binding.listpaypalone1RowModel = listpaypalone1RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listpaypalone1RowModel>) {
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
      item: Listpaypalone1RowModel
    ) {
    }
  }

  inner class RowListpaypalone1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListpaypalone1Binding = RowListpaypalone1Binding.bind(itemView)
  }
}
