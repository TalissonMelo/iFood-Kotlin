package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.FormaPagamento
import com.talissonmelo.iFood.service.FormaPagamentoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/pagamentos"])
@CrossOrigin("http://localhost:4200")
class FormaPagamentoResource constructor( @Autowired var service: FormaPagamentoService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<FormaPagamento> {
        return service.listarPagamentos();
    }

    @GetMapping(value = ["/{idPagamento}"])
    fun buscarId(@PathVariable idPagamento: Long): ResponseEntity<FormaPagamento> {
         var pagamento: FormaPagamento = service.buscarPagamentoId(idPagamento);
        return ResponseEntity.ok().body(pagamento);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@RequestBody pagamento: FormaPagamento): FormaPagamento {
        return service.cadastrarPagamento(pagamento);
    }

    @PutMapping(value = ["/{idPagamento}"])
    fun atualizar(@PathVariable idPagamento: Long, @RequestBody pagamento: FormaPagamento): ResponseEntity<FormaPagamento>{
        var pagamentoAtualizado : FormaPagamento = service.atualizarPagamento(idPagamento, pagamento);
        return ResponseEntity.ok().body(pagamento);
    }

    @DeleteMapping(value = ["/{idPagamento}"])
    fun deletar(@PathVariable idPagamento: Long): ResponseEntity<Void> {
        service.deletarPagamentoId(idPagamento);
        return ResponseEntity.noContent().build();
    }
}