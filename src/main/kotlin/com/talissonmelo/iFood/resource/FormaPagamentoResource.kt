package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.FormaPagamento
import com.talissonmelo.iFood.service.FormaPagamentoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus

@Service
class FormaPagamentoResource {

    @Autowired
    lateinit var service: FormaPagamentoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<FormaPagamento> {
        return service.listarPagamentos();
    }
}