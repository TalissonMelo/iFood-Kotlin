package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.Cidade
import com.talissonmelo.iFood.service.CidadeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/cidades"])
class CidadeResource constructor(@Autowired var service: CidadeService){

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<Cidade> {
        return service.listarCidades();
    }

    @GetMapping(value = ["/nome-cidade"])
    fun buscarCidadesNome(nome: String) : ResponseEntity<List<Cidade>> {
        var cidades: List<Cidade> = service.buscarCidadesNome(nome);
        return ResponseEntity.ok().body(cidades);
    }

    @GetMapping(value = ["/cidade"])
    fun buscarCidade(nome: String): ResponseEntity<Cidade> {
        var cidade: Cidade =  service.buscarCidadeNome(nome);
        return ResponseEntity.ok().body(cidade);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@RequestBody cidade: Cidade) : ResponseEntity<Cidade> {
        var novaCidade: Cidade = service.cadastrarCidade(cidade);
        return ResponseEntity.ok().body(novaCidade);
    }

    @DeleteMapping(value = ["/{idCidade}"])
    fun deletar(@PathVariable idCidade: Long): ResponseEntity<Void> {
        service.deletarCidade(idCidade);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = ["/{idCidade}"])
    fun atualizar(@PathVariable idCidade: Long, @RequestBody cidade: Cidade): ResponseEntity<Cidade> {
        var cidade: Cidade = service.atualizarCidade(idCidade,cidade);
        return ResponseEntity.ok().body(cidade);
    }

    @GetMapping(value = ["/{idCidade}"])
    fun buscarPorId(@PathVariable idCidade: Long): ResponseEntity<Cidade> {
        var cidade: Cidade = service.buscarCidadeId(idCidade);
        return ResponseEntity.ok().body(cidade);
    }
}