package com.starmakers.app.modules.requestone.ui
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.modules.artistbookongfour.ui.ArtistBookongFourActivity
import com.starmakers.app.modules.artistrequestinfo.ArtistRequestInfo
import com.starmakers.app.modules.frame316.ui.Frame316Activity
import com.starmakers.app.responses.ArtistRequests
import com.starmakers.app.service.ApiManager

class ArtistRequestAdapter(  var list: List<ArtistRequests> ): RecyclerView.Adapter<ArtistRequestAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArtistRequestAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.row_artist_request,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtistRequestAdapter.ViewHolder, position: Int) {
        return  holder.bindView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder( view: View): RecyclerView.ViewHolder(view){
        val name:TextView=itemView.findViewById(R.id.txtSudeep)
        val actor:TextView=itemView.findViewById(R.id.txtActor)
        val location:TextView=itemView.findViewById(R.id.txtBangalore)
        val image:ImageView=itemView.findViewById(R.id.imageRectangleNineteen)
        var artistId=-1


        // Define the corner radius in pixels (converted from dp)
        val cornerRadiusInPixels = 15 // Change to your dimension resource

        // Create a RequestOptions object with the RoundedCorners transformation
        val requestOptions = RequestOptions()
            .transform(RoundedCorners(cornerRadiusInPixels))
        fun bindView(postModel: ArtistRequests) {
            name.text=postModel.artist_name
            actor.text=postModel.category_name
            location.text=postModel.location
            artistId=postModel.id




            if (!postModel.artist_pictures.isEmpty()) {
                val file =
                    postModel.artist_pictures[0].artist_picture // Assuming postModel.profile is a File object

                val imgUrl = file.let { ApiManager.getImageUrl(it) }
//                Picasso.get()
//                    .load(imgUrl)
//                    .into(image)

                Glide.with(itemView)
                    .load(imgUrl) // Replace with your image URL or resource ID
                    .apply(requestOptions)
                    .into(image)
            }
            name.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, ArtistRequestInfo::class.java)
                intent.putExtra("profileDataId", artistId) // Pass the id to the new activity
                context.startActivity(intent)
            }

            image.setOnClickListener{
                val context = itemView.context
                val intent = Intent(context, ArtistRequestInfo::class.java)
                intent.putExtra("profileDataId", artistId) // Pass the id to the new activity
                context.startActivity(intent)
            }

        }
    }
}