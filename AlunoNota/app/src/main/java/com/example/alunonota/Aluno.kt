package com.example.alunonota


import android.os.Parcelable
import kotlinx.parcelize.Parcelize;

@Parcelize
class Aluno (
    val nome: String,
    val media: Double,
    val presenca: Int) : Parcelable
    {

    }