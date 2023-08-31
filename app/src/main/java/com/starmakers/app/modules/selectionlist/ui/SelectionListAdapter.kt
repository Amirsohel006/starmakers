package com.starmakers.app.modules.selectionlist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowSelectionListBinding
import com.starmakers.app.modules.selectionlist.`data`.model.SelectionListRowModel
import kotlin.Int
import kotlin.collections.List

class SelectionListAdapter(
  var list: List<SelectionListRowModel>
) : RecyclerView.Adapter<SelectionListAdapter.RowSelectionListVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowSelectionListVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_selection_list,parent,false)
    return RowSelectionListVH(view)
  }

  override fun onBindViewHolder(holder: RowSelectionListVH, position: Int) {
    val selectionListRowModel = SelectionListRowModel()
    // TODO uncomment following line after integration with data source
    // val selectionListRowModel = list[position]
    holder.binding.selectionListRowModel = selectionListRowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<SelectionListRowModel>) {
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
      item: SelectionListRowModel
    ) {
    }
  }

  inner class RowSelectionListVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowSelectionListBinding = RowSelectionListBinding.bind(itemView)
    init {
      binding.linearRowellipsethirtyfiveOne.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, SelectionListRowModel())
      }
    }
  }
}
