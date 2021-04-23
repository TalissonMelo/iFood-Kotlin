package com.talissonmelo.iFood.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.OffsetDateTime
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

        @CreationTimestamp
        @Column(nullable = false,  columnDefinition = "datetime")
        var dataAtualizacao: OffsetDateTime = OffsetDateTime.now(),

        @UpdateTimestamp
        @Column(nullable = false,  columnDefinition = "datetime")
        var dataCadastro:  OffsetDateTime = OffsetDateTime.now(),

        @ManyToOne
        @JoinColumn(name = "cozinha_id", nullable = false)
        var cozinha: Cozinha = Cozinha(1,""),

        @JsonIgnore
        @Embedded
        var endereco: Endereco = Endereco("", "", "", "", "", Cidade(1,"", Estado(1,""))),

        @JsonIgnore
        @OneToMany(mappedBy = "restaurante")
        var produtos : List<Produto>  = mutableListOf(),

        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "restaurante_forma_pagamento",
                joinColumns = [JoinColumn(name = "restaurante_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "forma_pagamento_id", referencedColumnName = "id")])
        var formasPagamentos: List<FormaPagamento>  = mutableListOf(),
)