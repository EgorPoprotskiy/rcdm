package com.egorpoprotskiy.rcdm.data

import android.content.Context
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.Ait

class AitDataSource(private val context: Context) {
    fun loadAitDataSourse(): List<Ait> {
        return listOf<Ait>(
            Ait(context.getString(R.string.alsn_heading)),
            Ait(context.getString(R.string.saut_heading)),
            Ait(context.getString(R.string.ktsm_heading))
        )
    }
}