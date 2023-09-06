package com.starmakers.app.modules.helpone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.responses.PrivacyPolicyModel


class PrivacyPolicyAdapter(val postModel: ArrayList<PrivacyPolicyModel>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.privacy_list_item,parent,false)
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
    private val txtPrivacyPolicyCount: TextView =itemView.findViewById(R.id.txtPrivacyPolicyCount)
    private val txtPrivacyPolicy: TextView =itemView.findViewById(R.id.txtPrivacyPolicy)


    fun bindView(postModel: PrivacyPolicyModel){
        txtPrivacyPolicyCount.text= postModel.id.toString()
        txtPrivacyPolicy.text=postModel.content
    }
}