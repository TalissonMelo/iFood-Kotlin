package com.talissonmelo.iFood.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
data class Restaurante (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var nome: String,

        @Column(name = "taxa_frete")
    var taxaFrete: BigDecimal
)