package com.starmakers.app.modules.auditions.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowAuditionsBinding
import com.starmakers.app.modules.auditions.`data`.model.AuditionsRowModel
import kotlin.Int
import kotlin.collections.List

class AuditionsAdapter(
  var list: List<AuditionsRowModel>
) : RecyclerView.Adapter<AuditionsAdapter.RowAuditionsVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowAuditionsVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_auditions,parent,false)
    return RowAuditionsVH(view)
  }

  override fun onBindViewHolder(holder: RowAuditionsVH, position: Int) {
    val auditionsRowModel = AuditionsRowModel()
    // TODO uncomment following line after integration with data source
    // val auditionsRowModel = list[position]
    holder.binding.auditionsRowModel = auditionsRowModel
  }

  override fun getItemCount(): Int = 5
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<AuditionsRowModel>) {
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
      item: AuditionsRowModel
    ) {
    }
  }

  inner class RowAuditionsVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowAuditionsBinding = RowAuditionsBinding.bind(itemView)
    init {
      binding.imageRectangle106.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, AuditionsRowModel())
      }
      binding.btnParticipate.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, AuditionsRowModel())
      }
    }
  }
}
