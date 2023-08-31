package com.starmakers.app.modules.activities.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowActivitiesBinding
import com.starmakers.app.modules.activities.`data`.model.ActivitiesRowModel
import kotlin.Int
import kotlin.collections.List

class ActivitiesAdapter(
  var list: List<ActivitiesRowModel>
) : RecyclerView.Adapter<ActivitiesAdapter.RowActivitiesVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowActivitiesVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_activities,parent,false)
    return RowActivitiesVH(view)
  }

  override fun onBindViewHolder(holder: RowActivitiesVH, position: Int) {
    val activitiesRowModel = ActivitiesRowModel()
    // TODO uncomment following line after integration with data source
    // val activitiesRowModel = list[position]
    holder.binding.activitiesRowModel = activitiesRowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ActivitiesRowModel>) {
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
      item: ActivitiesRowModel
    ) {
    }
  }

  inner class RowActivitiesVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowActivitiesBinding = RowActivitiesBinding.bind(itemView)
    init {
      binding.linearColumnuntitleddesign.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, ActivitiesRowModel())
      }
    }
  }
}
