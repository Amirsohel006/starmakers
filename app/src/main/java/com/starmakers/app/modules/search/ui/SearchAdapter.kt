package com.starmakers.app.modules.search.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.starmakers.app.R
import com.starmakers.app.responses.Artists
import com.starmakers.app.responses.Campaigns
import com.starmakers.app.responses.SearchResponses
import com.starmakers.app.service.ApiManager

class SearchAdapter(
    var items: List<Any>, // List of artists and campaigns
    private val onItemClick: (Any) -> Unit // Click listener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)

        fun bind(item: Any) {
            if (item is Artists) {
                // Bind artist data
                nameTextView.text = item.artistName

                val image=item.artistPictures.firstOrNull()?.artistPicture
                val file=ApiManager.getImageUrl(image!!)
                // Load image using Glide or any other image loading library
                Glide.with(itemView).load(file).into(imageView)
            } else if (item is Campaigns) {
                // Bind campaign data
                nameTextView.text = item.campaignsName
                // Load image using Glide or any other image loading library
                val image=item.moviePoster
                val file=ApiManager.getImageUrl(image!!)
                Glide.with(itemView).load(file).into(imageView)
            }

            itemView.setOnClickListener { onItemClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_result, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
