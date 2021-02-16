package com.talissonmelo.iFood.model

import javax.persistence.*

@Entity
data class Grupo (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 1,

        @Column(nullable = false)
        var nome: String = "",

        @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        @JoinTable(name = "grupo_permissao",
                joinColumns = [JoinColumn(name = "grupo_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "permissao_id", referencedColumnName = "id")])
        var permissoes: List<Permissao> =  mutableListOf()
)