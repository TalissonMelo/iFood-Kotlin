package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Restaurante
import com.talissonmelo.iFood.service.RestauranteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/restaurantes"])
class RestauranteResource constructor(@Autowired var service: RestauranteService){

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<Restaurante> {
        return service.listarRestaurantes();
    }

    @GetMapping(value = ["/por-taxa-frete"])
    @ResponseStatus(HttpStatus.OK)
    fun listarRestaurantesTaxaFrete(taxaInicial: Double, taxaFinal: Double): List<Restaurante> {
        return service.listarRestaurantesTaxaFrete(taxaInicial, taxaFinal);
    }

    @GetMapping(value = ["/por-nome/id-cozinha"])
    @ResponseStatus(HttpStatus.OK)
    fun listarRestauranteNomeAndCozinhaId(nome: String, idCozinha: Long): List<Restaurante> {
        return service.listarRestaurantesNomeAndCozinhaId(nome,idCozinha);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(restaurante: Restaurante) : Restaurante {
        return service.cadastrarRestaurante(restaurante);
    }
}