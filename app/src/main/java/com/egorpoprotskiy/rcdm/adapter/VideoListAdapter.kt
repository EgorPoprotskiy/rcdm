package com.egorpoprotskiy.rcdm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egorpoprotskiy.rcdm.databinding.ItemPs1Binding
import com.egorpoprotskiy.rcdm.model.Video
//48
class VideoListAdapter(
    private val dataset: List<Video>,
    private val onVideoClicked: (Video) -> Unit
) : RecyclerView.Adapter<VideoListAdapter.VideoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VideoListAdapter.VideoViewHolder {
        return VideoViewHolder(ItemPs1Binding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: VideoListAdapter.VideoViewHolder, position: Int) {
        val current = dataset[position]
        holder.bind(current)
        holder.itemView.setOnClickListener {
            onVideoClicked(current)
        }
    }

    override fun getItemCount(): Int = dataset.size

    inner class VideoViewHolder(private var binding: ItemPs1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(video: Video) {
            binding.psLabel.text = video.videoHeading
        }
    }
}