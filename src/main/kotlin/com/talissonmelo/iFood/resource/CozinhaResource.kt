package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Cozinha
import com.talissonmelo.iFood.service.CozinhaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/cozinhas"])
@CrossOrigin("http://localhost:4200")
class CozinhaResource constructor(@Autowired var service: CozinhaService) {

    @GetMapping
    fun listar(): List<Cozinha> {
        return service.listarCozinhas();
    }

    @GetMapping(value = ["/{idCozinha}"])
    fun buscarCozinhaId(@PathVariable idCozinha: Long): ResponseEntity<Cozinha> {
        var cozinha: Cozinha = service.buscarCozinhaId(idCozinha);
        return ResponseEntity.ok().body(cozinha);
    }

    @GetMapping(value = ["/nome"])
    fun existeCozinha(nome: String): Boolean{
        return service.existeCozinha(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@Valid @RequestBody cozinha: Cozinha) : ResponseEntity<Cozinha> {
        var novaCozinha: Cozinha = service.cadastrarCozinha(cozinha);
        return ResponseEntity.ok().body(novaCozinha);
    }

    @PutMapping(value = ["/{idCozinha}"])
    fun atualizar(@Valid @PathVariable idCozinha: Long, @RequestBody cozinha: Cozinha): ResponseEntity<Cozinha> {
        var novaCozinha: Cozinha = service.atualizarCozinha(idCozinha, cozinha);
        return ResponseEntity.ok().body(novaCozinha);
    }

    @DeleteMapping(value = ["/{idCozinha}"])
    fun deletarCozinha(@PathVariable idCozinha: Long): ResponseEntity<Void> {
        service.deletarCozinha(idCozinha);
        return ResponseEntity.noContent().build();
    }
}