package com.talissonmelo.iFood.model

import com.talissonmelo.iFood.model.enums.StatusPedido
import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
data class Pedido (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 1,
        var subTotal: Double = 0.0,
        var taxaFrete: Double = 0.0,
        var valorTotal: Double = 0.0,

        @Embedded
        var endereco: Endereco = Endereco(),

        var status : StatusPedido = StatusPedido.CANCELADO,

        @CreationTimestamp
        var dataCriacao:Date = Date(),

        var dataConfirmacao :Date = Date(),
        var dataCancelamento: Date = Date(),
        var dataEntrega: Date = Date(),

        @ManyToOne
        @JoinColumn(nullable = false, name = "forma_pagamento_id")
        var formaPagamento: FormaPagamento = FormaPagamento(),

        @ManyToOne
        @JoinColumn(nullable = false, name = "restaurante_id")
        var restaurante: Restaurante = Restaurante(),

        @ManyToOne
        @JoinColumn(name = "usuario_cliente_id", nullable = false)
        var cliente: Usuario = Usuario(),

        @OneToMany(mappedBy = "pedido")
        var itens: List<ItemPedido> = mutableListOf(),
)