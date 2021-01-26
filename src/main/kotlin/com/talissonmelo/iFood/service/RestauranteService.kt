package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.model.Restaurante
import com.talissonmelo.iFood.repository.RestauranteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RestauranteService {

    @Autowired
    lateinit var repository: RestauranteRepository;

    fun listarRestaurantes(): List<Restaurante> {
        return repository.findAll();
    }

    fun cadastrarRestaurante(restaurante: Restaurante): Restaurante{
        return repository.save(restaurante);
    }
}