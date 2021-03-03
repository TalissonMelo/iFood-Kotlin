package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Estado
import com.talissonmelo.iFood.service.EstadoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/estados"])
@CrossOrigin("http://localhost:4200")
class EstadoResource  constructor(@Autowired var service: EstadoService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<Estado> {
        return service.listarEstados();
    }

    @GetMapping(value = ["/{idEstado}"])
    fun buscarId(@PathVariable idEstado: Long): ResponseEntity<Estado> {
        var estado: Estado = service.buscarEstadoId(idEstado);
        return ResponseEntity.ok().body(estado);
    }
}