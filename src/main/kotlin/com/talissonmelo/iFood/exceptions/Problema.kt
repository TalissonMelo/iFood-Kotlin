package com.talissonmelo.iFood.exceptions

data class Problema (
        var mensagem: String = "",
        var status: Int = 1,
        var campos: ArrayList<Campo> = ArrayList()
)