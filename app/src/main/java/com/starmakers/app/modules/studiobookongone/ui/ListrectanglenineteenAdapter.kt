package com.starmakers.app.modules.studiobookongone.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListrectanglenineteenBinding
import com.starmakers.app.modules.frame316.ui.Frame316Activity
import com.starmakers.app.modules.studiobookongone.`data`.model.ListrectanglenineteenRowModel
import com.starmakers.app.responses.EditingStudio
import com.starmakers.app.responses.Studio
import kotlin.Int
import kotlin.collections.List

class ListrectanglenineteenAdapter(
  var list:  List<Studio>
) : RecyclerView.Adapter<ListrectanglenineteenAdapter.RowListrectanglenineteenVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectanglenineteenVH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectanglenineteen,parent,false)
    return RowListrectanglenineteenVH(view)
  }

  override fun onBindViewHolder(holder: RowListrectanglenineteenVH, position: Int) {
    return  holder.bindView(list[position])
  }

  override fun getItemCount(): Int {
    return list.size
  }

  public fun updateData(newData: List<Studio>) {
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
    //val binding: RowListrectanglenineteenBinding = RowListrectanglenineteenBinding.bind(itemView)



    val studioName: TextView =itemView.findViewById(R.id.txtRamanandStudio)
    val location: TextView =itemView.findViewById(R.id.txtLocationJPN1)
    val txtMeasurement1: TextView =itemView.findViewById(R.id.txtMeasurement1)
    val image: ImageView =itemView.findViewById(R.id.imageRectangleNineteen)
    val requestButton: AppCompatButton =itemView.findViewById(R.id.btnRequest)
    var requestid=-1

    fun bindView(postModel: Studio) {
      studioName.text=postModel.studio_name
      location.text=postModel.location
      txtMeasurement1.text=postModel.budget.toString()
      if (!postModel.studio_picture.isEmpty()) {
        Picasso.get()
          .load(postModel.studio_picture[0].studio_picture)
          .into(image);
      } else {
        // Handle the case when the studio_picture list is empty
        // You can set a default image or show an error message.
      }

      requestid=postModel.id
      requestButton.setOnClickListener {
        val context = itemView.context
        val intent = Intent(context, Frame316Activity::class.java)
        intent.putExtra("requestId", requestid) // Pass the id to the new activity
        context.startActivity(intent)
      }


    }



    init {
//      binding.imageRectangleNineteen.setOnClickListener {
//        // TODO replace with value from datasource
//        clickListener?.onItemClick(it, adapterPosition, ListrectanglenineteenRowModel())
//      }
//      binding.txtRamanandStudio.setOnClickListener {
//        // TODO replace with value from datasource
//        clickListener?.onItemClick(it, adapterPosition, ListrectanglenineteenRowModel())
//      }
//      binding.btnRequest.setOnClickListener {
//        // TODO replace with value from datasource
//        clickListener?.onItemClick(it, adapterPosition, ListrectanglenineteenRowModel())
//      }
    }
  }
}
