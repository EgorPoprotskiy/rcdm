package com.egorpoprotskiy.rcdm.data

import android.content.Context
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.EasdGroup

class EasdGroupeDataSource(private val context: Context) {
    fun loadEasdGroupDataSource(): List<EasdGroup> {
        return listOf(
            EasdGroup(context.getString(R.string.rcdm)),
            EasdGroup(context.getString(R.string.upravlenie_dvzd)),
            EasdGroup(context.getString(R.string.p_sluzhba)),
            EasdGroup(context.getString(R.string.sh_sluzhba)),
            EasdGroup(context.getString(R.string.e_sluzhba))
        )
    }
}