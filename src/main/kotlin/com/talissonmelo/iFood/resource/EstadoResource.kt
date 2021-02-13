package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Estado
import com.talissonmelo.iFood.service.EstadoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/estados"])
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@RequestBody estado: Estado): Estado {
        return service.cadastrarEstado(estado);
    }

    @PutMapping(value = ["/{idEstado}"])
    fun atualizar(@PathVariable idEstado: Long, @RequestBody estado: Estado) : ResponseEntity<Estado> {
        var estadoAtualizado: Estado = service.atualizarEstado(idEstado,estado);
        return ResponseEntity.ok().body(estadoAtualizado);
    }

    @DeleteMapping(value = ["/{idEstado}"])
    fun deletar(@PathVariable idEstado: Long): ResponseEntity<Void> {
        service.deletarEstadoId(idEstado);
        return ResponseEntity.noContent().build();
    }

}