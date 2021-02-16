package com.talissonmelo.iFood.model

import javax.persistence.*

@Entity
data class Produto (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Long = 1,
        var nome: String = "",
        var descricao : String = "",
        var preco : Double = 0.0,
        var ativo : Boolean = true,

        @ManyToOne
        @JoinColumn(name = "restaurante_id", nullable = false)
        var restaurante :Restaurante = Restaurante()
)