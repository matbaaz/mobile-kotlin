package com.example.flagquiz

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class DadosDoJogo (
    val score: Int,
    val flagNumber: Int,
    val userName: String,
): Parcelable {
}