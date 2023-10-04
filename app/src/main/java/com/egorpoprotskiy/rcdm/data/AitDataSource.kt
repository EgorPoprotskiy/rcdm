package com.egorpoprotskiy.rcdm.data

import android.content.Context
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.Ait

class AitDataSource(private val context: Context) {
    fun loadAitDataSourse(): List<Ait> {
        return listOf<Ait>(
            //35 Чтобы в TextView отображался текст, а не числа, надо указать контекст с получением строки
            Ait(context.getString(R.string.alsn_heading), context.getString(R.string.alsn_description)),
            Ait(context.getString(R.string.saut_heading), context.getString(R.string.saut_description)),
            Ait(context.getString(R.string.ktsm_heading), context.getString(R.string.ktsm_description))
        )
    }
}