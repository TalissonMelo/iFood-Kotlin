package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.model.Restaurante
import com.talissonmelo.iFood.repository.RestauranteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RestauranteService constructor(@Autowired val repository: RestauranteRepository) {

    fun listarRestaurantes(): List<Restaurante> {
        return repository.findAll();
    }

    fun listarRestaurantesTaxaFrete(taxaInicial: Double, taxaFinal: Double): List<Restaurante> {
        return repository.findByTaxaFreteBetween(taxaInicial,taxaFinal);
    }

    fun listarRestaurantesNomeAndCozinhaId(nome: String, idCozinha: Long): List<Restaurante> {
        return repository.findByNomeContainingAndCozinhaId(nome,idCozinha);
    }

    fun cadastrarRestaurante(restaurante: Restaurante): Restaurante{
        return repository.save(restaurante);
    }
}