package com.egorpoprotskiy.rcdm.data

import android.content.Context
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.Ps
//40 Создание модели данных для путеизмерения
class PsDataSource(private val context: Context) {
    fun loadPsDataSource(): List<Ps>{
        return listOf<Ps>(
            Ps(context.getString(R.string.shirina_heading), context.getString(R.string.shirina_description)),
            Ps(context.getString(R.string.oshk_heading), context.getString(R.string.oshk_description)),
            Ps(context.getString(R.string.uroven_heading), context.getString(R.string.uroven_description)),
            Ps(context.getString(R.string.perecos_heading), context.getString(R.string.perecos_description)),
            Ps(context.getString(R.string.prosadka_heading), context.getString(R.string.prosadka_description)),
            Ps(context.getString(R.string.rihtovka_heading), context.getString(R.string.rihtovka_description)),
            Ps(context.getString(R.string.sochetaniya_heading), context.getString(R.string.sochetaniya_description)),
            Ps(context.getString(R.string.prosadka_is_heading), context.getString(R.string.prosadka_is_description)),
            Ps(context.getString(R.string.most_and_tonnel_heading), context.getString(R.string.most_and_tonnel_description)),
            Ps(context.getString(R.string.bi_heading), context.getString(R.string.bi_description)),
            Ps(context.getString(R.string.dl_nerovnosti_heading), context.getString(R.string.dl_nerovnosti_description)),
            Ps(context.getString(R.string.ocenka_km_heading), context.getString(R.string.ocenka_km_description)),
            Ps(context.getString(R.string.ocenka_uch_heading), context.getString(R.string.ocenka_uch_description))
        )
    }
}