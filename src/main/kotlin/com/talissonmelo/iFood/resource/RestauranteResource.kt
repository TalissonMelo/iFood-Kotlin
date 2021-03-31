package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Restaurante
import com.talissonmelo.iFood.service.RestauranteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/restaurantes"])
@CrossOrigin("http://localhost:4200")
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@RequestBody restaurante: Restaurante) : ResponseEntity<Restaurante> {
        return ResponseEntity.ok().body(service.cadastrarRestaurante(restaurante));
    }

    @PutMapping(value = ["/{idRestaurante}"])
    fun atualizar(@PathVariable idRestaurante: Long, @RequestBody restaurante: Restaurante) : ResponseEntity<Restaurante> {
        var restauranteAtualizado : Restaurante = service.atualizarRestauranteId(idRestaurante, restaurante);
        return ResponseEntity.ok().body(restauranteAtualizado);
    }
}