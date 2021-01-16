package com.talissonmelo.iFood.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Cozinha (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        var nome: String
)