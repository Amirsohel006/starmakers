package com.starmakers.app.modules.helptwo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.responses.AboutUsModel

class AboutUsAdapter(val postModel: MutableList<AboutUsModel>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postModel.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        return holder.bindView(postModel[position])
    }
}

class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val txtIntroduction: TextView =itemView.findViewById(R.id.txtIntruductionTitlle)
   // private val txtHistory: TextView =itemView.findViewById(R.id.txthistory)
    private val description:TextView=itemView.findViewById(R.id.txtDescriptionofIntruduction)


    fun bindView(postModel: AboutUsModel){
        txtIntroduction.text=postModel.aboutus_title
       // txtHistory.text=postModel.history
        description.text=postModel.aboutus_content
    }
}