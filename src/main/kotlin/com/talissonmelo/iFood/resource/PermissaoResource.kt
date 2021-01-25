package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Permissao
import com.talissonmelo.iFood.service.PermissaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/permissoes"])
class PermissaoResource {

    @Autowired
    lateinit var service: PermissaoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<Permissao> {
        return service.listarPermissoes();
    }
}