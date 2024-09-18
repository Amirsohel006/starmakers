package com.starmakers.app.modules.request.ui
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.modules.artistbookongfour.ui.ArtistBookongFourActivity
import com.starmakers.app.modules.auditionstwo.ui.AuditionsTwoActivity
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
        var studioId=-1


        val aboutImage:ImageView=itemView.findViewById(R.id.imageInfo)
        // Define the corner radius in pixels (converted from dp)
        val cornerRadiusInPixels = 15 // Change to your dimension resource

        // Create a RequestOptions object with the RoundedCorners transformation
        val requestOptions = RequestOptions()
            .transform(RoundedCorners(cornerRadiusInPixels))


        val btnRequested:AppCompatButton=itemView.findViewById(R.id.btnRequested)
        fun bindView(postModel: StudioRequests) {
            studioName.text=postModel.studio_name
            studioCost.text=postModel.budget
            studioLocation.text=postModel.location
            studioId=postModel.studio


            if (postModel.studio_picture.isNotEmpty()) {
                val file = postModel.studio_picture[0].studio_picture
                // Now you can safely access file
                val imgUrl= file.let { ApiManager.getImageUrl(it) }
//                Picasso.get()
//                    .load(imgUrl)
//                    .into(image)

                Glide.with(itemView)
                    .load(imgUrl) // Replace with your image URL or resource ID
                    .apply(requestOptions)
                    .into(image)
            } else {
                // Handle the case when postModel.studio_picture is empty
                // You might want to set a default value or display a message to the user
            }
// Assuming postModel.profile is a File object


            val bookingStatus = postModel.booking_studio

            when (bookingStatus) {
                "pending" -> {
                    btnRequested.text = "Requested"
                    btnRequested.setTextColor(Color.WHITE)
                    btnRequested.setBackgroundResource(R.drawable.pending_button_background) // Rounded pending button
                }
                "accept" -> {
                    btnRequested.text = "Booked"
                    btnRequested.setTextColor(Color.WHITE)
                    btnRequested.setBackgroundResource(R.drawable.booked_button_background) // Rounded booked button
                }
                else -> {
                    btnRequested.text = "Not Booked"
                    btnRequested.setTextColor(Color.WHITE)
                    btnRequested.setBackgroundResource(R.drawable.not_booked_button_background) // Rounded not booked button
                }
            }





            studioName.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, AuditionsTwoActivity::class.java)
                intent.putExtra("studioId", studioId) // Pass the id to the new activity
                intent.putExtra("bookingStudio",postModel.booking_studio)
                context.startActivity(intent)
            }
            image.setOnClickListener{
                val context = itemView.context
                val intent = Intent(context, AuditionsTwoActivity::class.java)
                intent.putExtra("studioId", studioId) // Pass the id to the new activity
                intent.putExtra("bookingStudio",postModel.booking_studio)
                context.startActivity(intent)
            }

            aboutImage.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, AuditionsTwoActivity::class.java)
                intent.putExtra("studioId", studioId) // Pass the id to the new activity
                intent.putExtra("bookingStudio",postModel.booking_studio)
                context.startActivity(intent)
            }

        }
    }
}