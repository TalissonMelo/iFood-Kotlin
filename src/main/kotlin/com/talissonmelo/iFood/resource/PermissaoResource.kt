package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Estado
import com.talissonmelo.iFood.model.Permissao
import com.talissonmelo.iFood.repository.PermissaoRepository
import com.talissonmelo.iFood.service.EstadoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/permissoes"])
@CrossOrigin("http://localhost:4200")
class PermissaoResource constructor(@Autowired var repository: PermissaoRepository) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<Permissao> {
        return repository.findAll();
    }
}