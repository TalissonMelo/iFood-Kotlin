package com.talissonmelo.iFood.model

import javax.persistence.*

@Entity
data class FormaPagamento (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 1,

        @Column(nullable = false)
        var descricao: String = "",
)