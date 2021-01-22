package com.talissonmelo.iFood.model

import javax.persistence.*

@Entity
data class Restaurante(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 1,

    @Column(nullable = false)
    var nome: String = "",

    @Column(name = "taxa_frete", nullable = false)
    var taxaFrete: Double = 10.0,

    @ManyToOne
    @JoinColumn(name = "cozinha_id")
    var cozinha: Cozinha = Cozinha(1,"Brasileira")
)

