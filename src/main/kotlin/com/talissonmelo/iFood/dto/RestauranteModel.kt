package com.talissonmelo.iFood.dto

import com.talissonmelo.iFood.model.Cozinha

class RestauranteModel (

    var id: Long = 1,
    var nome: String = "",
    var taxaFrete: Double = 10.0,
    var cozinha: Cozinha = Cozinha(1,""),

)