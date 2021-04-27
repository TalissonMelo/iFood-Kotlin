package com.talissonmelo.iFood.dto.cadastro

import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

class RestauranteCadastro (

        @NotBlank(message = "Campo nome e obrigatório.")
    var nome: String = "",

        @PositiveOrZero(message = "Campo tem que ser maior que zero.")
    var taxaFrete: Double = 10.0,

        @Valid
        @NotNull
    var cozinha: RestauranteCozinhaCadastro = RestauranteCozinhaCadastro(1),
)