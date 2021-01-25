package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Restaurante
import com.talissonmelo.iFood.service.RestauranteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/restaurantes"])
class RestauranteResource {

    @Autowired
    lateinit var service: RestauranteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<Restaurante> {
        return service.listarRestaurantes();
    }
}