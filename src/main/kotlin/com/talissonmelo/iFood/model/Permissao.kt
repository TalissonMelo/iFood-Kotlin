package com.talissonmelo.iFood.model

import javax.persistence.*

@Entity
data class Permissao (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 1,

        @Column(nullable = false)
        var nome: String = "",

        var descricao: String = "",
)