package com.egorpoprotskiy.rcdm.data

import android.content.Context
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.EasdChapter

class EasdChapterDataSource(private val context: Context) {
    fun loadEasdChapterDataSource(): List<EasdChapter> {
        return listOf(
            EasdChapter(context.getString(R.string.rcdm),
                listOf(
                    context.getString(R.string.rcdmNach),
                    context.getString(R.string.rcdmz1),
                    context.getString(R.string.rcdmz2))),
            EasdChapter(context.getString(R.string.upravlenie_dvzd),
                listOf(
                    context.getString(R.string.n),
                    context.getString(R.string.nz),
                    context.getString(R.string.rb),
                    context.getString(R.string.dcup)
                )
            )
        )
    }
}