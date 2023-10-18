package com.egorpoprotskiy.rcdm.data

import android.content.Context
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.Nk

class NkDataSource(private val context: Context) {
    fun loadNkDataSource(): List<Nk> {
        return listOf(
            Nk(context.getString(R.string.nk_bag1_heading), context.getString(R.string.nk_bag1_description)),
            Nk(context.getString(R.string.nk_bag2_heading), context.getString(R.string.nk_bag2_description)),
            Nk(context.getString(R.string.nk_bag3_heading), context.getString(R.string.nk_bag3_description)),
            Nk(context.getString(R.string.nk_bag4_heading), context.getString(R.string.nk_bag4_description))
        )
    }
}