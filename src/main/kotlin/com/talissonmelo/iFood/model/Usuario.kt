package com.talissonmelo.iFood.model

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
data class Usuario (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 1,

        @Column(nullable = false)
        var nome: String = "",

        @Column(nullable = false)
        var email: String = "",

        @Column(nullable = false)
        var senha: String = "",

        @CreationTimestamp
        @Column(nullable = false, columnDefinition = "datetime")
        var dataCadastro : Date = Date(),

        @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        @JoinTable(name = "usuario_grupo",
                joinColumns = [JoinColumn(name = "usuario_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "grupo_id", referencedColumnName = "id")])
        var grupos: List<Grupo> =  mutableListOf()

)