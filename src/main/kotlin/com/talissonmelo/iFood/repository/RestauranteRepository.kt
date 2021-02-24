package com.talissonmelo.iFood.repository

import com.talissonmelo.iFood.model.Restaurante
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RestauranteRepository : JpaRepository<Restaurante, Long> {

    fun findByTaxaFreteBetween(taxaInicial: Double, taxaFinal: Double) : List<Restaurante>;

    @Query("from Restaurante where nome like %:nome% and cozinha.id = :idCozinha")
    fun consultarPorNome(nome:String, idCozinha: Long): List<Restaurante>;

    fun findFirstByNomeContaining(nome: String) : Restaurante;

    fun findTop2ByNomeContaining(nome:String): List<Restaurante>;

    fun countByCozinhaId(idCozinha: Long): Int;

    @Query("from Restaurante res join res.cozinha join fetch res.formasPagamentos")
    override fun findAll(): List<Restaurante>
}