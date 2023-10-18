package com.egorpoprotskiy.rcdm.data

import android.content.Context
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.Ks

class KsDataSource(private val context: Context) {
    fun loadKsDataSource(): List<Ks> {
        return listOf(
            Ks(context.getString(R.string.ks_zigzag_heading), context.getString(R.string.ks_zigzag_description)),
            Ks(context.getString(R.string.ks_bag2_heading), context.getString(R.string.ks_bag2_description))
        )
    }
}