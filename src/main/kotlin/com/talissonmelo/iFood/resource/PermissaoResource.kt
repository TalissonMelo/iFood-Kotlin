package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Estado
import com.talissonmelo.iFood.model.Permissao
import com.talissonmelo.iFood.repository.PermissaoRepository
import com.talissonmelo.iFood.service.EstadoService
import com.talissonmelo.iFood.service.PermissaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/permissoes"])
class PermissaoResource constructor(@Autowired var repository: PermissaoRepository,@Autowired var service: PermissaoService ) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<Permissao> {
        return repository.findAll();
    }

    @GetMapping(value = ["/{idPermissao}"])
    fun buscarId(@PathVariable idPermissao: Long): ResponseEntity<Permissao> {
        var permissao: Permissao = service.buscarPermissaoId(idPermissao);
        return ResponseEntity.ok().body(permissao);
    }

    @DeleteMapping(value = ["/{idPermissao}"])
    fun deletarPermissaoId(@PathVariable idPermissao: Long): ResponseEntity<Permissao> {
        service.deletarPermissaoId(idPermissao);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvar(@RequestBody permissao: Permissao): ResponseEntity<Permissao> {
        var permissao: Permissao = service.salvarPermissao(permissao);
        return ResponseEntity.ok().body(permissao);
    }

}