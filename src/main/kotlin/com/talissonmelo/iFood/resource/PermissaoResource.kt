package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Permissao
import com.talissonmelo.iFood.service.PermissaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/permissoes"])
class PermissaoResource constructor( @Autowired var service: PermissaoService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<Permissao> {
        return service.listarPermissoes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(permissao: Permissao) : Permissao {
        return service.cadastrarPermissao(permissao);
    }
}