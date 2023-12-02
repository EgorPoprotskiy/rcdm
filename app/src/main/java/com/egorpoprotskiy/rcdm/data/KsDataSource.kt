package com.egorpoprotskiy.rcdm.data

import android.content.Context
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.Ks
//45
class KsDataSource(private val context: Context) {
    fun loadKsDataSource(): List<Ks> {
        return listOf(
            Ks(context.getString(R.string.ks_visota_heading), context.getString(R.string.ks_visota_description)),
            Ks(context.getString(R.string.ks_uklon_heading), context.getString(R.string.ks_uklon_description)),
            Ks(context.getString(R.string.ks_vinos_heading), context.getString(R.string.ks_vinos_description)),
            Ks(context.getString(R.string.ks_zigzag_heading), context.getString(R.string.ks_zigzag_description)),
            Ks(context.getString(R.string.ks_nenagr_fiksator_heading), context.getString(R.string.ks_nenagr_fiksator_description)),
            Ks(context.getString(R.string.ks_podhvat_fiksatora_heading), context.getString(R.string.ks_podhvat_fiksatora_description)),
            Ks(context.getString(R.string.ks_odnost_zigzag_heading), context.getString(R.string.ks_odnost_zigzag_description)),
            Ks(context.getString(R.string.ks_podhvat_v_prolete_heading), context.getString(R.string.ks_podhvat_v_prolete_description)),
            Ks(context.getString(R.string.ks_udar_heading), context.getString(R.string.ks_udar_description)),
            Ks(context.getString(R.string.ks_otriv_heading), context.getString(R.string.ks_otriv_description)),
            Ks(context.getString(R.string.ks_visota_na_vozd_strelke_heading), context.getString(R.string.ks_visota_na_vozd_strelke_description)),
            Ks(context.getString(R.string.ks_nazhatie_heading), context.getString(R.string.ks_nazhatie_description)),
            Ks(context.getString(R.string.ks_nagrev_heading), context.getString(R.string.ks_nagrev_description)),
            Ks(context.getString(R.string.ks_def_izol_heading), context.getString(R.string.ks_def_izol_description)),
            Ks(context.getString(R.string.ks_strela_podvesa_heading), context.getString(R.string.ks_strela_podvesa_description)),
        )
    }
}