package com.starmakers.app.modules.activities.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.starmakers.app.R
import com.starmakers.app.modules.campaign.ui.CampaignActivity
import com.starmakers.app.modules.selectionlisttwo.ui.SelectionListTwoActivity
import com.starmakers.app.service.ApiManager
import com.starmakers.app.responses.MyAuditionRequest

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


        // Define the corner radius in pixels (converted from dp)
        val cornerRadiusInPixels = 15 // Change to your dimension resource

        // Create a RequestOptions object with the RoundedCorners transformation
        val requestOptions = RequestOptions()
            .transform(RoundedCorners(cornerRadiusInPixels))
        fun bindView(postModel: MyAuditionRequest) {



            val file =
                postModel.movie_poster// Assuming postModel.profile is a File object

            val imgUrl = file.let { ApiManager.getImageUrl(it) }
//            Picasso.get()
//                .load(imgUrl)
//                .into(image)


            Glide.with(itemView)
                .load(imgUrl) // Replace with your image URL or resource ID
                .apply(requestOptions)
                .into(image)


            image.setOnClickListener {
//                val context = itemView.context
//                val intent = Intent(context, CampaignActivity::class.java)
//                intent.putExtra("poster", imgUrl)
//                intent.putExtra("movie_name",postModel.movie_name)
//                intent.putExtra("venue",postModel.venue)
//                intent.putExtra("audtion_date",postModel.audition_date)
//                intent.putExtra("start_time",postModel.timings_from)
//                intent.putExtra("end_time",postModel.timings_from)
//                intent.putExtra("storyline",postModel.movie_name)
//                intent.putExtra("artistDataId", postModel.id)
//
//                context.startActivity(intent)

                    val context = itemView.context
                    val intent = Intent(context, SelectionListTwoActivity::class.java)
                    intent.putExtra("artistDataId", postModel.audition_ID) // Pass the id to the new activity
                    context.startActivity(intent)
            }
        }
    }
}
