package com.talissonmelo.iFood.resource

import com.talissonmelo.iFood.model.FormaPagamento
import com.talissonmelo.iFood.repository.FormaPagamentoRepository
import com.talissonmelo.iFood.service.FormaPagamentoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/forma-pagamentos"])
@CrossOrigin("http://localhost:4200")
class FormaPagamentoResource constructor(@Autowired var repository: FormaPagamentoRepository,
                                         @Autowired var serive: FormaPagamentoService) {

    @GetMapping
    fun buscarFormaPagamentos(): List<FormaPagamento> {
        return repository.findAll();
    }

    @DeleteMapping(value = ["/{idPagamento}"])
    fun deletarFormaPagamento(@PathVariable idPagamento: Long): ResponseEntity<Void> {
        serive.deletarFormaPagamento(idPagamento);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = ["/{idPagamento}"])
    fun buscarPagamento(@PathVariable idPagamento: Long): ResponseEntity<FormaPagamento> {
        var pagamento:FormaPagamento = serive.buscarFormaPagamentoId(idPagamento);
        return ResponseEntity.ok().body(pagamento);
    }
}