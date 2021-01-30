package com.talissonmelo.iFood.repository

import com.talissonmelo.iFood.model.Cidade
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CidadeRepository: JpaRepository<Cidade, Long> {

    fun findByNome(nome: String) : Optional<Cidade>;
    fun findByNomeLike(nome: String) : List<Cidade>;
}