package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Cozinha
import com.talissonmelo.iFood.service.CozinhaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/cozinhas"])
class CozinhaResource {

    @Autowired
    lateinit var service: CozinhaService;

    @GetMapping
    fun listar(): List<Cozinha> {
        return service.listarCozinhas();
    }
}