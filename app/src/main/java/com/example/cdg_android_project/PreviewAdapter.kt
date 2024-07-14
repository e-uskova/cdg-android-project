package com.example.cdg_android_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class PreviewAdapter : ListAdapter<String, PreviewAdapter.PreviewViewHolder>(previewDiffUtil()) {
    private lateinit var previewListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        previewListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return PreviewViewHolder(view, previewListener)
    }

    override fun onBindViewHolder(holder: PreviewViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PreviewViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: String) {
            itemView.findViewById<TextView>(R.id.txtTeams).text = item
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}

fun previewDiffUtil() = object : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
}