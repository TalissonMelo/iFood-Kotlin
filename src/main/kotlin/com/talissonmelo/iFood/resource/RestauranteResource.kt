package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.dto.RestauranteModel
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
    fun listar(): List<RestauranteModel> {
        return restauranteParaRestauranteModels(service.listarRestaurantes());
    }

    @GetMapping(value = ["/{idRestaurante}"])
    fun buscarId(@PathVariable idRestaurante: Long): ResponseEntity<RestauranteModel> {
        var restaurante: Restaurante = service.buscarRestauranteId(idRestaurante);
        var restauranteModel: RestauranteModel = restauranteParaRestauranteModel(restaurante);
        return ResponseEntity.ok().body(restauranteModel);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@RequestBody restaurante: Restaurante) : ResponseEntity<RestauranteModel> {
        return ResponseEntity.ok().body(restauranteParaRestauranteModel(service.cadastrarRestaurante(restaurante)));
    }

    @PutMapping(value = ["/{idRestaurante}"])
    fun atualizar(@PathVariable idRestaurante: Long, @RequestBody restaurante: Restaurante) : ResponseEntity<RestauranteModel> {
        var restauranteAtualizado : Restaurante = service.atualizarRestauranteId(idRestaurante, restaurante);
        return ResponseEntity.ok().body(restauranteParaRestauranteModel(restauranteAtualizado));
    }

    private fun restauranteParaRestauranteModel(restaurante: Restaurante): RestauranteModel {
        var restauranteModel: RestauranteModel = RestauranteModel();
        restauranteModel.id = restaurante.id;
        restauranteModel.nome = restaurante.nome;
        restauranteModel.taxaFrete = restauranteModel.taxaFrete;
        restauranteModel.cozinha = restaurante.cozinha;
        return restauranteModel;
    }

    private fun restauranteParaRestauranteModels(restaurantes: List<Restaurante>): List<RestauranteModel> {
       return restaurantes.map { restaurante -> restauranteParaRestauranteModel(restaurante)  }
    }
}