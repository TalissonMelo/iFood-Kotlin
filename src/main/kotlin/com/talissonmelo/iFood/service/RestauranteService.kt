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

    fun cadastrarRestaurante(restaurante: Restaurante): Restaurante{
        return repository.save(restaurante);
    }

    fun atualizarRestauranteId(idRestaurante: Long, restaurante: Restaurante) : Restaurante{
        var restauranteAtualizar : Restaurante = buscarRestauranteId(idRestaurante);
        BeanUtils.copyProperties(restaurante, restauranteAtualizar, "id", "formasPagamentos", "endereco", "dataCadastro", "produtos");
        return repository.save(restauranteAtualizar);
    }
}