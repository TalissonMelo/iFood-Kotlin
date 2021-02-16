package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.model.Restaurante
import com.talissonmelo.iFood.repository.RestauranteRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RestauranteService constructor(@Autowired val repository: RestauranteRepository) {

    fun listarRestaurantes(): List<Restaurante> {
        return repository.findAll();
    }

    fun buscarRestauranteId(idRestaurante: Long): Restaurante{
        return repository.findById(idRestaurante).get();
    }

    fun listarRestaurantesTaxaFrete(taxaInicial: Double, taxaFinal: Double): List<Restaurante> {
        return repository.findByTaxaFreteBetween(taxaInicial,taxaFinal);
    }

    fun listarRestaurantesNomeAndCozinhaId(nome: String, idCozinha: Long): List<Restaurante> {
        return repository.consultarPorNome(nome,idCozinha);
    }

    fun cadastrarRestaurante(restaurante: Restaurante): Restaurante{
        return repository.save(restaurante);
    }

    fun buscarUmRestaurantePorNome(nome: String) : Restaurante {
        return repository.findFirstByNomeContaining(nome);
    }

    fun buscarDoisRestaurantePorNome(nome: String) : List<Restaurante> {
        return repository.findTop2ByNomeContaining(nome);
    }

    fun cozinhaContemRestaurantes(idCozinha: Long): Int {
        return repository.countByCozinhaId(idCozinha);
    }

    fun atualizarRestauranteId(idRestaurante: Long, restaurante: Restaurante) : Restaurante{
        var restauranteAtualizar : Restaurante = buscarRestauranteId(idRestaurante);
        BeanUtils.copyProperties(restaurante, restauranteAtualizar, "id", "formasPagamentos", "endereco", "dataCadastro", "produtos");
        return repository.save(restauranteAtualizar);
    }

    fun deletaRestauranteId(idRestaurante: Long) {
        repository.deleteById(idRestaurante);
    }
}