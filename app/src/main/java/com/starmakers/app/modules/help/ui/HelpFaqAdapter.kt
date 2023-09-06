package com.starmakers.app.modules.help.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.starmakers.app.R
import com.starmakers.app.responses.FAQItem

class HelpFaqAdapter(
    private val notificationList: List<FAQItem>,
    private val onItemClick: (FAQItem) -> Unit
) : RecyclerView.Adapter<HelpFaqAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.faq_layout, parent, false)
        return NotificationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification = notificationList[position]
        holder.bind(notification)
    }

    override fun getItemCount(): Int = notificationList.size

    inner class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val id: TextView = itemView.findViewById(R.id.txtquestion)
        private val question:TextView=itemView.findViewById(R.id.questiontextview)
        fun bind(notification: FAQItem) {
            id.text= notification.id.toString()
            question.text=notification.question
            itemView.setOnClickListener { onItemClick(notification) }
        }
    }
}
