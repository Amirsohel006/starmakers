package com.starmakers.app.modules.auditionsfour.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.starmakers.app.R
import com.starmakers.app.responses.RequestUserData

class profilepicadapter(
    private var profileDataList: List<RequestUserData>):
    RecyclerView.Adapter<profilepicadapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): profilepicadapter.ViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.uploadpicvalues,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: profilepicadapter.ViewHolder, position: Int) {
        return  holder.bindView(profileDataList[position])
    }

    override fun getItemCount(): Int {
    return  profileDataList.size
    }

    inner class ViewHolder(
        view: View
    ): RecyclerView.ViewHolder(view){
        val profilePicture:ImageView=itemView.findViewById(R.id.imagePlus)

        fun bindView(postModel: RequestUserData) {

            Picasso.get()
                .load(postModel.profile)
                .into(profilePicture)

        }

    }
}