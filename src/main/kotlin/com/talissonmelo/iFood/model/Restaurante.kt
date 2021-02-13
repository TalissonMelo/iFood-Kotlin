package com.talissonmelo.iFood.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*


@Entity
data class Restaurante (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 1,

    @Column(nullable = false)
    var nome: String = "",

    @Column(name = "taxa_frete", nullable = false)
    var taxaFrete: Double = 10.0,

    @ManyToOne
    @JoinColumn(name = "cozinha_id")
    var cozinha: Cozinha = Cozinha(1,"Brasileira"),

    @JsonIgnore
    @Embedded
    var endereco: Endereco = Endereco("", "", "", "", "", Cidade(1,"", Estado(1,""))),

    @JsonIgnore
    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(name = "restaurante_forma_pagamento",
        joinColumns = [JoinColumn(name = "restaurante_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "forma_pagamento_id", referencedColumnName = "id")])
    var formasPagamentos: List<FormaPagamento>  = mutableListOf()
)

