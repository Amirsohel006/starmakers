package com.starmakers.app.modules.auditionsthree.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.databinding.RowListrectangle146Binding
import com.starmakers.app.modules.auditionsthree.`data`.model.Listrectangle146RowModel
import com.starmakers.app.responses.BudgetResponse
import com.starmakers.app.service.ApiManager
import org.w3c.dom.Text
import kotlin.Int
import kotlin.collections.List

class Listrectangle146Adapter(
  var list: List<BudgetResponse>
) : RecyclerView.Adapter<Listrectangle146Adapter.RowListrectangle146VH>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle146VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle146,parent,false)
    return RowListrectangle146VH(view)
  }

  override fun onBindViewHolder(holder: RowListrectangle146VH, position: Int) {
    holder.bindView(list[position])
  }

  override fun getItemCount(): Int {
    return list.size
  }

  public fun updateData(newData: List<BudgetResponse>) {
    list = newData
    notifyDataSetChanged()
  }



  inner class RowListrectangle146VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListrectangle146Binding = RowListrectangle146Binding.bind(itemView)

    val moviname:TextView=itemView.findViewById(R.id.txtMovieKantara1)
    val gener:TextView=itemView.findViewById(R.id.txtGenreMystery1)
    val budge:TextView=itemView.findViewById(R.id.txtAppxBudget1)
    val donation:TextView=itemView.findViewById(R.id.txtPrice)
    val movieposter:ImageView=itemView.findViewById(R.id.imageRectangle146)

    fun bindView(postmodel:BudgetResponse){
      moviname.text=postmodel.campaignName
      gener.text=postmodel.genere
      budge.text=postmodel.appxBudget
      donation.text=postmodel.amount
      val image=postmodel.moviePoster?:""
      val file=ApiManager.getImageUrl(image)

      Log.d("File Image",file)
      Picasso.get().load(file).into(movieposter)
    }

  }
}
