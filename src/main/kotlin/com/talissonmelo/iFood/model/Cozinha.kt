package com.talissonmelo.iFood.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Cozinha (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 1,

        @NotBlank(message = "Nome da Cozinha é Obrigatório!.")
        @Column(nullable = false)
        var nome: String = ""
)