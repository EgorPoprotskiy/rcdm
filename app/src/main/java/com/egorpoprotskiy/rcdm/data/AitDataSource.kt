package com.egorpoprotskiy.rcdm.data

import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.Ait

class AitDataSource {
    fun loadAitDataSourse(): List<Ait> {
        return listOf(
            Ait(R.string.alsn_heading, R.string.alsn_description),
            Ait(R.string.saut_heading, R.string.saut_description)
        )
    }
}