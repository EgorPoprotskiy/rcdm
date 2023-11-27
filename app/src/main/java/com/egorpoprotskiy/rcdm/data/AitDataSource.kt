package com.egorpoprotskiy.rcdm.data

import android.content.Context
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.Ait

class AitDataSource(private val context: Context) {
    fun loadAitDataSourse(): List<Ait> {
        return listOf<Ait>(
            //35 Чтобы в TextView отображался текст, а не числа, надо указать контекст с получением строки
            Ait(context.getString(R.string.alsn_interval_heading), context.getString(R.string.alsn_interval_description)),
            Ait(context.getString(R.string.alsn_tok_post_heading), context.getString(R.string.alsn_tok_post_description)),
            Ait(context.getString(R.string.alsn_tok_per_heading), context.getString(R.string.alsn_tok_per_description)),
            Ait(context.getString(R.string.alsn_tok_auto_heading), context.getString(R.string.alsn_tok_auto_description)),
            Ait(context.getString(R.string.alsen_tok_heading), context.getString(R.string.alsen_tok_description)),
            Ait(context.getString(R.string.pam_heading), context.getString(R.string.pam_description)),
            Ait(context.getString(R.string.saut_heading), context.getString(R.string.saut_description)),
            Ait(context.getString(R.string.ktsm_heading), context.getString(R.string.ktsm_description)),
            Ait(context.getString(R.string.ktsm_pkl_heading), context.getString(R.string.ktsm_pkl_description))
        )
    }
}