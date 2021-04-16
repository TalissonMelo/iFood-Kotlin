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
@CrossOrigin("http://localhost:4200")
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
}