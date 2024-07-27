package com.example.cdg_android_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class PreviewAdapter : ListAdapter<Match, PreviewAdapter.PreviewViewHolder>(previewDiffUtil()) {
    private lateinit var previewListener : onItemClickListener

    public override fun getItem(position: Int): Match {
        return super.getItem(position)
    }

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
        fun bind(item: Match) {
            itemView.findViewById<TextView>(R.id.txtTeams).text = itemView.context.getString(R.string.teams_msg, item.homeTeam, item.awayTeam)
            itemView.findViewById<TextView>(R.id.txtScore).text = itemView.context.getString(R.string.score_msg, item.homeTeamScore, item.awayTeamScore)
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}

fun previewDiffUtil() = object : DiffUtil.ItemCallback<Match>() {
    override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean = oldItem == newItem
}
