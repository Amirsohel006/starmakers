package com.starmakers.app.modules.financialoverview.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.databinding.RowGridrectangletenBinding
import com.starmakers.app.modules.artistrequestinfo.ArtistRequestInfo
import com.starmakers.app.modules.auditionsone.ui.AuditionsOneActivity
import com.starmakers.app.modules.financialoverview.`data`.model.GridrectangletenRowModel
import com.starmakers.app.responses.Campaign
import com.starmakers.app.service.ApiManager
import org.w3c.dom.Text
import kotlin.Int
import kotlin.collections.List

class GridrectangletenAdapter(
  var list: List<Campaign>
) : RecyclerView.Adapter<GridrectangletenAdapter.RowGridrectangletenVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowGridrectangletenVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_gridrectangleten,parent,false)
    return RowGridrectangletenVH(view)
  }

  override fun onBindViewHolder(holder: RowGridrectangletenVH, position: Int) {
    return  holder.bindView(list[position])
  }

  override fun getItemCount(): Int{
    return list.size
  }
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Campaign>) {
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
      item: GridrectangletenRowModel
    ) {
    }
  }

  inner class RowGridrectangletenVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowGridrectangletenBinding = RowGridrectangletenBinding.bind(itemView)

    val image:ImageView=itemView.findViewById(R.id.imageRectangleTen)
    val moviename:TextView=itemView.findViewById(R.id.txtMovieKantara)
    val gener:TextView=itemView.findViewById(R.id.txtGenreMystery)
    var campaignId=-1
    fun bindView(postModel:Campaign){
      moviename.text=postModel.campaigns_name
      gener.text=postModel.genere

      campaignId=postModel.id
      val file =
        postModel.movie_poster// Assuming postModel.profile is a File object

      val imgUrl = file?.let { ApiManager.getImageUrl(it) }
      Picasso.get()
        .load(imgUrl)
        .into(image)

      binding.linearRowviewdetails.setOnClickListener {
        val context = itemView.context
        val intent = Intent(context, AuditionsOneActivity::class.java)
        intent.putExtra("campaignId", campaignId) // Pass the id to the new activity
        context.startActivity(intent)
      }


    }


    init {
      binding.linearRowviewdetails.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, GridrectangletenRowModel())
      }
    }
  }
}
