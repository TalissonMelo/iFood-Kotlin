package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Cidade
import com.talissonmelo.iFood.service.CidadeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/cidades"])
class CidadeResource {

    @Autowired
    lateinit var service: CidadeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<Cidade> {
        return service.listarCidades();
    }
}