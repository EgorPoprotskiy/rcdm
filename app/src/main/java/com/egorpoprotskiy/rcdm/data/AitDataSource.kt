package com.egorpoprotskiy.rcdm.data

import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.Ait

class AitDataSource {
    fun loadAitDataSourse(): List<Ait> {
        return listOf(
            Ait(R.string.alsn_heading),
            Ait(R.string.saut_heading),
            Ait(R.string.ktsm_heading)
        )
    }
}