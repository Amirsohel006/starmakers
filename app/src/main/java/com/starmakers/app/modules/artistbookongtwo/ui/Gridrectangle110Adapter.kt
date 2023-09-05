package com.starmakers.app.modules.artistbookongtwo.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.databinding.RowGridrectangle110Binding
import com.starmakers.app.modules.artistbookongfour.ui.ArtistBookongFourActivity
import com.starmakers.app.modules.artistbookongtwo.data.model.Gridrectangle110RowModel
import com.starmakers.app.responses.ProfileData

class Gridrectangle110Adapter(
  private var profileDataList: List<ProfileData>
) : RecyclerView.Adapter<Gridrectangle110Adapter.ViewHolder>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.row_gridrectangle110, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val profileData = profileDataList[position]
    holder.artistNameTextView.text = profileData.artistName
    Picasso.get()
      .load(profileData.artistPictures[0].artistPicture)
      .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE) // Disable memory caching
      .networkPolicy(NetworkPolicy.NO_CACHE) // Disable network caching
      .into(holder.profilePictureImageView)

    // Set an item click listener
    holder.itemView.setOnClickListener {
      clickListener?.onItemClick(it, position, profileData)
    }
  }

  override fun getItemCount(): Int = profileDataList.size

  @SuppressLint("NotifyDataSetChanged")
  fun updateData(newData: List<ProfileData>) {
    profileDataList = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(view: View, position: Int, item: ProfileData)
  }

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // Define your item views here using the binding
    // Example: val artistNameTextView = binding.artistNameTextView
    // You'll need to update this part based on your item layout

    // Initialize your item views here
    // Example: val binding = RowGridrectangle110Binding.bind(itemView)
    // You'll need to update this part based on your item layout

    // Set an item click listener if needed
    // Example: itemView.setOnClickListener { }


    val artistNameTextView: TextView = itemView.findViewById(R.id.txtGroupTwenty)
    val profilePictureImageView: ImageView = itemView.findViewById(R.id.imageRectangle110)

    // Initialize your item views here
    val binding: RowGridrectangle110Binding = RowGridrectangle110Binding.bind(itemView)


    init {
      itemView.setOnClickListener {
        // Handle item click here, for example, start a new activity
        val context = itemView.context
        val profileData = profileDataList[adapterPosition]

        // Create an intent to start the new activity (replace NewActivity::class.java with your desired activity)
        val intent = Intent(context, ArtistBookongFourActivity::class.java)

        // You can pass data to the new activity if needed
        intent.putExtra("profileDataId", profileData.id)

        // Start the new activity
        context.startActivity(intent)
      }

    }
  }
}
