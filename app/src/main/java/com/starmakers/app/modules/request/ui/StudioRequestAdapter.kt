package com.starmakers.app.modules.request.ui
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.responses.StudioRequests
import com.starmakers.app.service.ApiManager
import org.w3c.dom.Text

class StudioRequestAdapter (  var list: List<StudioRequests> ): RecyclerView.Adapter<StudioRequestAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.row_studio_request,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return  holder.bindView(list[position])
    }



    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder( view: View): RecyclerView.ViewHolder(view){

        val studioName:TextView=itemView.findViewById(R.id.txtRamanandStudio)
        val studioCost:TextView=itemView.findViewById(R.id.txtMeasurement1)
        val studioLocation:TextView=itemView.findViewById(R.id.txtLocationJPN1)
        val image:ImageView=itemView.findViewById(R.id.imageRectangleNineteen)

        fun bindView(postModel: StudioRequests) {
            studioName.text=postModel.studio_name
            studioCost.text=postModel.budget
            studioLocation.text=postModel.location


            val file = postModel.studio_picture[0].studio_picture // Assuming postModel.profile is a File object

            val imgUrl= file?.let { ApiManager.getImageUrl(it) }
            Picasso.get()
                .load(imgUrl)
                .into(image)
        }
    }
}