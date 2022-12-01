package com.nsadisha.retrofitapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nsadisha.retrofitapp.R
import com.nsadisha.retrofitapp.model.NetworkVideo


class VideoAdapter: RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {
    private var videos = emptyList<NetworkVideo>()
    inner class VideoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_item, parent, false
        ))
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.title).text = videos[position].title
        holder.itemView.findViewById<TextView>(R.id.description).text = videos[position].description

    }

    override fun getItemCount(): Int {
        return videos.size
    }

    fun setData(_videos: List<NetworkVideo>){
        videos = _videos
        notifyDataSetChanged()
    }
}