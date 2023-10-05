package com.egorpoprotskiy.rcdm.data

import android.content.Context
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.Ps

class PsDataSource(private val context: Context) {
    fun loadPsDataSource(): List<Ps>{
        return listOf<Ps>(
            Ps(context.getString(R.string.uroven_heading), context.getString(R.string.uroven_description)),
            Ps(context.getString(R.string.perecos_heading), context.getString(R.string.perecos_description)),
            Ps(context.getString(R.string.rihtovka_heading), context.getString(R.string.rihtovka_description)),
            Ps(context.getString(R.string.prosadka_heading), context.getString(R.string.prosadka_description)),
            Ps(context.getString(R.string.shablon_heading), context.getString(R.string.shablon_description)),
        )
    }
}