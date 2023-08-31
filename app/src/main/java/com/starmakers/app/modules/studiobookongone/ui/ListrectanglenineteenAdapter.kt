package com.starmakers.app.modules.studiobookongone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListrectanglenineteenBinding
import com.starmakers.app.modules.studiobookongone.`data`.model.ListrectanglenineteenRowModel
import kotlin.Int
import kotlin.collections.List

class ListrectanglenineteenAdapter(
  var list: List<ListrectanglenineteenRowModel>
) : RecyclerView.Adapter<ListrectanglenineteenAdapter.RowListrectanglenineteenVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectanglenineteenVH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectanglenineteen,parent,false)
    return RowListrectanglenineteenVH(view)
  }

  override fun onBindViewHolder(holder: RowListrectanglenineteenVH, position: Int) {
    val listrectanglenineteenRowModel = ListrectanglenineteenRowModel()
    // TODO uncomment following line after integration with data source
    // val listrectanglenineteenRowModel = list[position]
    holder.binding.listrectanglenineteenRowModel = listrectanglenineteenRowModel
  }

  override fun getItemCount(): Int = 6
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListrectanglenineteenRowModel>) {
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
      item: ListrectanglenineteenRowModel
    ) {
    }
  }

  inner class RowListrectanglenineteenVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListrectanglenineteenBinding = RowListrectanglenineteenBinding.bind(itemView)
    init {
      binding.imageRectangleNineteen.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, ListrectanglenineteenRowModel())
      }
      binding.txtRamanandStudio.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, ListrectanglenineteenRowModel())
      }
      binding.btnRequest.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, ListrectanglenineteenRowModel())
      }
    }
  }
}
