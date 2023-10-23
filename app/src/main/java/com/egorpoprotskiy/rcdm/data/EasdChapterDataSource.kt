package com.egorpoprotskiy.rcdm.data

import android.content.Context
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.model.EasdChapter

class EasdChapterDataSource(private val context: Context) {
    fun loadEasdChapterDataSource(): List<EasdChapter> {
        return listOf(
            EasdChapter(context.getString(R.string.upravlenie_dvzd),
                listOf(
                    context.getString(R.string.n),
                    context.getString(R.string.nz),
                    context.getString(R.string.rb),
                    context.getString(R.string.dcup)
                )
            ),
            EasdChapter(context.getString(R.string.rcdm),
                listOf(
                    context.getString(R.string.rcdmNach),
                    context.getString(R.string.rcdmz1),
                    context.getString(R.string.rcdmz2)
                )
            ),
            EasdChapter(context.getString(R.string.p_sluzhba),
                listOf(
                    context.getString(R.string.p),
                    context.getString(R.string.pch1),
                    context.getString(R.string.pch2),
                    context.getString(R.string.pch5),
                    context.getString(R.string.pch7),
                    context.getString(R.string.pch8),
                    context.getString(R.string.pch9),
                    context.getString(R.string.pch10),
                    context.getString(R.string.pch11),
                    context.getString(R.string.pch12),
                    context.getString(R.string.pch13),
                    context.getString(R.string.pch14),
                    context.getString(R.string.pch15),
                    context.getString(R.string.pch16),
                    context.getString(R.string.pch17),
                    context.getString(R.string.pch18),
                    context.getString(R.string.pch19),
                    context.getString(R.string.pch20),
                    context.getString(R.string.pch21),
                    context.getString(R.string.pch22),
                    context.getString(R.string.pch23),
                    context.getString(R.string.pch24),
                )
            ),
            EasdChapter(context.getString(R.string.sh_sluzhba),
                listOf(
                    context.getString(R.string.sh),
                    context.getString(R.string.shch2),
                    context.getString(R.string.shch3),
                    context.getString(R.string.shch4),
                    context.getString(R.string.shch6),
                    context.getString(R.string.shch7),
                    context.getString(R.string.shch8),
                    context.getString(R.string.shch9),
                    context.getString(R.string.shch10),
                    context.getString(R.string.shch12),
                    context.getString(R.string.shch13),
                    context.getString(R.string.shch14),
                )
            ),
            EasdChapter(context.getString(R.string.e_sluzhba),
                listOf(
                    context.getString(R.string.e),
                    context.getString(R.string.ech1),
                    context.getString(R.string.ech2),
                    context.getString(R.string.ech3),
                )
            ),
        )
    }
}