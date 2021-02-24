package com.talissonmelo.iFood.model

import javax.persistence.*

@Embeddable
data class Endereco (

        @Column(name = "end_cep")
        var cep: String = "",

        @Column(name = "end_logradouro")
        var logradouro: String = "",

        @Column(name = "end_complemento")
        var complemento: String = "",

        @Column(name = "end_numero")
        var numero: String = "",

        @Column(name = "end_bairro")
        var bairro: String = "",

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "end_cidade_id")
        var cidade: Cidade = Cidade(1,"", Estado(1, ""))
)