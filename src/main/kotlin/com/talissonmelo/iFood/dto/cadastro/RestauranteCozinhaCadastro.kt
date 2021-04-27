package com.talissonmelo.iFood.dto.cadastro

import javax.validation.constraints.NotNull

class RestauranteCozinhaCadastro(

        @NotNull(message = "Campo id e obrigatório.")
        var id: Long = 1
)
