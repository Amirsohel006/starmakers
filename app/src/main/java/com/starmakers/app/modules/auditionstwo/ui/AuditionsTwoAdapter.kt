package com.starmakers.app.modules.auditionstwo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowAuditionsTwoBinding
import com.starmakers.app.modules.auditionstwo.`data`.model.AuditionsTwoRowModel
import kotlin.Int
import kotlin.collections.List

class AuditionsTwoAdapter(
  var list: List<AuditionsTwoRowModel>
) : RecyclerView.Adapter<AuditionsTwoAdapter.RowAuditionsTwoVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowAuditionsTwoVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_auditions_two,parent,false)
    return RowAuditionsTwoVH(view)
  }

  override fun onBindViewHolder(holder: RowAuditionsTwoVH, position: Int) {
    val auditionsTwoRowModel = AuditionsTwoRowModel()
    // TODO uncomment following line after integration with data source
    // val auditionsTwoRowModel = list[position]
    holder.binding.auditionsTwoRowModel = auditionsTwoRowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<AuditionsTwoRowModel>) {
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
      item: AuditionsTwoRowModel
    ) {
    }
  }

  inner class RowAuditionsTwoVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowAuditionsTwoBinding = RowAuditionsTwoBinding.bind(itemView)
  }
}
