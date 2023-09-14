package com.starmakers.app.modules.activities.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.service.ApiManager
import layout.MyAuditionRequest

data class MyAuditionAdapter(  var list: List<MyAuditionRequest> ): RecyclerView.Adapter<MyAuditionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_myaudition_request, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bindView(list[position])
    }


    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val image: ImageView = itemView.findViewById(R.id.imageRectangle106)

        fun bindView(postModel: MyAuditionRequest) {


            val file =
                postModel.movie_poster// Assuming postModel.profile is a File object

            val imgUrl = file?.let { ApiManager.getImageUrl(it) }
            Picasso.get()
                .load(imgUrl)
                .into(image)
        }
    }
}
