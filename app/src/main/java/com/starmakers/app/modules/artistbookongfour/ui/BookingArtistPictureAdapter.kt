import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.responses.BookingArtistPicture
import com.starmakers.app.responses.BookingMoviePicture
import com.starmakers.app.responses.BookingResponseList

class BookingArtistPictureAdapter(private val context: Context, private val artistPictures: ArrayList<BookingArtistPicture>) :
    RecyclerView.Adapter<BookingArtistPictureAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.profilepics_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return  holder.bindView(artistPictures[position])
    }

    override fun getItemCount(): Int {
        return artistPictures.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val profilePictureImageView: ImageView = itemView.findViewById(R.id.imagemovie)
        //var name:TextView=itemView.findViewById(R.id.name)

        // Define the corner radius in pixels (converted from dp)
        val cornerRadiusInPixels = 15 // Change to your dimension resource

        // Create a RequestOptions object with the RoundedCorners transformation
        val requestOptions = RequestOptions()
            .transform(RoundedCorners(cornerRadiusInPixels))

        fun bindView(postModel: BookingArtistPicture) {

//            Picasso.get()
//                .load(postModel.artistPicture)
//                .into(profilePictureImageView)


            Glide.with(itemView)
                .load(postModel.artistPicture) // Replace with your image URL or resource ID
                .apply(requestOptions)
                .into(profilePictureImageView)
        }
    }
}
