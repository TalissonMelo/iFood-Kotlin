package com.talissonmelo.iFood.repository

import com.talissonmelo.iFood.model.Restaurante
import org.springframework.data.jpa.repository.JpaRepository

interface RestauranteRepository : JpaRepository<Restaurante, Long> {

    fun findByTaxaFreteBetween(taxaInicial: Double, taxaFinal: Double) : List<Restaurante>;

    fun findByNomeContainingAndCozinhaId(nome: String, idCozinha: Long) : List<Restaurante>;
}