package com.starmakers.app.modules.studiobookong.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowStudioBookongBinding
import com.starmakers.app.modules.studiobookong.`data`.model.StudioBookongRowModel
import kotlin.Int
import kotlin.collections.List

class StudioBookongAdapter(
  var list: List<StudioBookongRowModel>
) : RecyclerView.Adapter<StudioBookongAdapter.RowStudioBookongVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowStudioBookongVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_studio_bookong,parent,false)
    return RowStudioBookongVH(view)
  }

  override fun onBindViewHolder(holder: RowStudioBookongVH, position: Int) {
    val studioBookongRowModel = StudioBookongRowModel()
    // TODO uncomment following line after integration with data source
    // val studioBookongRowModel = list[position]
    holder.binding.studioBookongRowModel = studioBookongRowModel
  }

  override fun getItemCount(): Int = 6
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<StudioBookongRowModel>) {
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
      item: StudioBookongRowModel
    ) {
    }
  }

  inner class RowStudioBookongVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowStudioBookongBinding = RowStudioBookongBinding.bind(itemView)
    init {
      binding.imageRectangleNineteen.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, StudioBookongRowModel())
      }
      binding.txtRamanandStudio.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, StudioBookongRowModel())
      }
      binding.btnRequest.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, StudioBookongRowModel())
      }
    }
  }
}
