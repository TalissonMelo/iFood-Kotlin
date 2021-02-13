package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Restaurante
import com.talissonmelo.iFood.service.RestauranteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/restaurantes"])
class RestauranteResource constructor(@Autowired var service: RestauranteService){

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<Restaurante> {
        return service.listarRestaurantes();
    }

    @GetMapping(value = ["/{idRestaurante}"])
    fun buscarId(@PathVariable idRestaurante: Long): ResponseEntity<Restaurante> {
        var restaurante: Restaurante = service.buscarRestauranteId(idRestaurante);
        return ResponseEntity.ok().body(restaurante);
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

    @GetMapping(value = ["/por-nome"])
    @ResponseStatus(HttpStatus.OK)
    fun listarRestauranteNome(nome: String): Restaurante {
        return service.buscarUmRestaurantePorNome(nome);
    }

    @GetMapping(value = ["/nome"])
    @ResponseStatus(HttpStatus.OK)
    fun listarDoisRestauranteNome(nome: String): List<Restaurante> {
        return service.buscarDoisRestaurantePorNome(nome);
    }

    @GetMapping(value = ["/cozinhas"])
    @ResponseStatus(HttpStatus.OK)
    fun listarCozinhaRestaurante(idCozinha: Long): Int {
        return service.cozinhaContemRestaurantes(idCozinha);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@RequestBody restaurante: Restaurante) : Restaurante {
        return service.cadastrarRestaurante(restaurante);
    }

    @PutMapping(value = ["/{idRestaurante}"])
    fun atualizar(@PathVariable idRestaurante: Long, @RequestBody restaurante: Restaurante) : ResponseEntity<Restaurante> {
        var restauranteAtualizado : Restaurante = service.atualizarRestauranteId(idRestaurante, restaurante);
        return ResponseEntity.ok().body(restauranteAtualizado);
    }

    @DeleteMapping(value = ["/{idRestaurante}"])
    fun deletarRestauranteId(@PathVariable idRestaurante: Long): ResponseEntity<Void> {
        service.deletaRestauranteId(idRestaurante);
        return ResponseEntity.noContent().build();
    }
}