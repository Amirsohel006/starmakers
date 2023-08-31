package com.starmakers.app.modules.studiobookongtwo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListrectanglenineteen1Binding
import com.starmakers.app.modules.studiobookongtwo.`data`.model.Listrectanglenineteen1RowModel
import kotlin.Int
import kotlin.collections.List

class ListrectanglenineteenAdapter(
  var list: List<Listrectanglenineteen1RowModel>
) : RecyclerView.Adapter<ListrectanglenineteenAdapter.RowListrectanglenineteen1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectanglenineteen1VH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectanglenineteen1,parent,false)
    return RowListrectanglenineteen1VH(view)
  }

  override fun onBindViewHolder(holder: RowListrectanglenineteen1VH, position: Int) {
    val listrectanglenineteen1RowModel = Listrectanglenineteen1RowModel()
    // TODO uncomment following line after integration with data source
    // val listrectanglenineteen1RowModel = list[position]
    holder.binding.listrectanglenineteen1RowModel = listrectanglenineteen1RowModel
  }

  override fun getItemCount(): Int = 6
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listrectanglenineteen1RowModel>) {
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
      item: Listrectanglenineteen1RowModel
    ) {
    }
  }

  inner class RowListrectanglenineteen1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListrectanglenineteen1Binding = RowListrectanglenineteen1Binding.bind(itemView)
    init {
      binding.imageRectangleNineteen.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, Listrectanglenineteen1RowModel())
      }
      binding.txtRamanandStudio.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, Listrectanglenineteen1RowModel())
      }
      binding.btnRequest.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, Listrectanglenineteen1RowModel())
      }
    }
  }
}
