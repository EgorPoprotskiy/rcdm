package com.egorpoprotskiy.rcdm.data

import android.content.Context
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.Ait
import com.egorpoprotskiy.rcdm.model.AllSystem

class AllSystemDataSource(private val context: Context) {
    fun loadAllSystemDataSource(): List<AllSystem> {
        return listOf(
            AllSystem(context.getString(R.string.ait_heading)),
            AllSystem(context.getString(R.string.ps_heading)),
            AllSystem(context.getString(R.string.nk_heading)),
            AllSystem(context.getString(R.string.ks_heading)),
            AllSystem(context.getString(R.string.video_headin)),

        )
    }
}
