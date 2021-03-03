package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Permissao
import com.talissonmelo.iFood.service.PermissaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/permissoes"])
@CrossOrigin("http://localhost:4200")
class PermissaoResource constructor( @Autowired var service: PermissaoService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<Permissao> {
        return service.listarPermissoes();
    }

    @GetMapping(value = ["/{idPermissao}"])
    fun buscarId(@PathVariable idPermissao: Long) : ResponseEntity<Permissao> {
        var permissao: Permissao = service.buscarPermissaoId(idPermissao);
        return ResponseEntity.ok().body(permissao);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@RequestBody permissao: Permissao) : ResponseEntity<Permissao> {
        return ResponseEntity.ok().body(service.cadastrarPermissao(permissao));
    }

    @PutMapping(value = ["/{idPermissao}"])
    fun atualizar(@PathVariable idPermissao: Long,@RequestBody permissao: Permissao): ResponseEntity<Permissao> {
        var permissaoAtualizacao: Permissao = service.atualiarPermissao(idPermissao,permissao);
        return ResponseEntity.ok().body(permissaoAtualizacao);
    }

    @DeleteMapping(value = ["/{idPermissao}"])
    fun deletar(@PathVariable idPermissao: Long): ResponseEntity<Void> {
        service.deletarPermissaoId(idPermissao);
        return ResponseEntity.noContent().build();
    }
}