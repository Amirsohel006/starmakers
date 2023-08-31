package com.starmakers.app.modules.regstrationdetails.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListpaypalone2Binding
import com.starmakers.app.modules.regstrationdetails.`data`.model.Listpaypalone2RowModel
import kotlin.Int
import kotlin.collections.List

class ListpaypaloneAdapter(
  var list: List<Listpaypalone2RowModel>
) : RecyclerView.Adapter<ListpaypaloneAdapter.RowListpaypalone2VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListpaypalone2VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listpaypalone2,parent,false)
    return RowListpaypalone2VH(view)
  }

  override fun onBindViewHolder(holder: RowListpaypalone2VH, position: Int) {
    val listpaypalone2RowModel = Listpaypalone2RowModel()
    // TODO uncomment following line after integration with data source
    // val listpaypalone2RowModel = list[position]
    holder.binding.listpaypalone2RowModel = listpaypalone2RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listpaypalone2RowModel>) {
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
      item: Listpaypalone2RowModel
    ) {
    }
  }

  inner class RowListpaypalone2VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListpaypalone2Binding = RowListpaypalone2Binding.bind(itemView)
  }
}
