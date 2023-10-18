package com.egorpoprotskiy.rcdm.data

import android.content.Context
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.Video

class VideoDataSource(private val context: Context) {
    fun loadVideoDataSource(): List<Video> {
        return listOf(
            Video(context.getString(R.string.video_zazor_heading), context.getString(R.string.video_zazor_description)),
            Video(context.getString(R.string.video_bolt_heading), context.getString(R.string.video_bolt_description)),
            Video(context.getString(R.string.video_mark_heading), context.getString(R.string.video_mark_description))
        )
    }
}