package com.talissonmelo.iFood.model

import javax.persistence.*

@Entity
data class ItemPedido (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 1,
        var precoUnitario: Double = 0.0,
        var procoTotal: Double = 0.0,
        var quantidade: Int = 1,
        var observacao: String = "",

        @ManyToOne
        @JoinColumn(nullable = false)
        var pedido: Pedido = Pedido(),

        @ManyToOne
        @JoinColumn(nullable = false)
        var produto: Produto = Produto()
)