package com.starmakers.app.modules.studiobookong.ui

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
import com.starmakers.app.databinding.RowStudioBookongBinding
import com.starmakers.app.modules.auditionsfour.ui.AuditionsFourActivity
import com.starmakers.app.modules.frame316.ui.Frame316Activity
import com.starmakers.app.modules.studiobookong.`data`.model.StudioBookongRowModel
import com.starmakers.app.responses.Data
import com.starmakers.app.responses.EditingStudio
import org.w3c.dom.Text
import kotlin.Int
import kotlin.collections.List

class StudioBookongAdapter(
  var list: List<EditingStudio>
) : RecyclerView.Adapter<StudioBookongAdapter.RowStudioBookongVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowStudioBookongVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_studio_bookong,parent,false)
    return RowStudioBookongVH(view)
  }

  override fun onBindViewHolder(holder: RowStudioBookongVH, position: Int) {
    return  holder.bindView(list[position])
   // val studioBookongRowModel = StudioBookongRowModel()
    // TODO uncomment following line after integration with data source
    // val studioBookongRowModel = list[position]
  //  holder.binding.studioBookongRowModel = studioBookongRowModel
  }

  override fun getItemCount(): Int {
    return list.size
  }
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<EditingStudio>) {
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
 //   val binding: RowStudioBookongBinding = RowStudioBookongBinding.bind(itemView)

    val studioName:TextView=itemView.findViewById(R.id.txtRamanandStudio)
    val location:TextView=itemView.findViewById(R.id.txtLocationJPN1)
    val txtMeasurement1:TextView=itemView.findViewById(R.id.txtMeasurement1)
    val image:ImageView=itemView.findViewById(R.id.imageRectangleNineteen)
    val requestButton:AppCompatButton=itemView.findViewById(R.id.btnRequest)
    var requestid=-1

    fun bindView(postModel: EditingStudio) {
      studioName.text=postModel.studio_name
      location.text=postModel.location
      txtMeasurement1.text=postModel.budget.toString()
      Picasso.get()
        .load(postModel.studio_picture[0].studio_picture)
        .into(image)

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
//        clickListener?.onItemClick(it, adapterPosition, StudioBookongRowModel())
//      }
//      binding.txtRamanandStudio.setOnClickListener {
//        // TODO replace with value from datasource
//        clickListener?.onItemClick(it, adapterPosition, StudioBookongRowModel())
//      }
//      binding.btnRequest.setOnClickListener {
//        // TODO replace with value from datasource
//        clickListener?.onItemClick(it, adapterPosition, StudioBookongRowModel())
//      }
    }
  }
}
