package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Estado
import com.talissonmelo.iFood.service.EstadoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/estados"])
class EstadoResource {

    @Autowired
    lateinit var service: EstadoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<Estado> {
        return service.listarEstados();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(estado: Estado): Estado {
        return service.cadastrarEstado(estado);
    }
}