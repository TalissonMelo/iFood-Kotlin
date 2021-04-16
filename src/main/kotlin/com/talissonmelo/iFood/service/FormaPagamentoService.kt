package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.model.FormaPagamento
import com.talissonmelo.iFood.repository.FormaPagamentoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class FormaPagamentoService constructor(@Autowired var repository: FormaPagamentoRepository) {

    @Transactional
    fun deletarFormaPagamento(idPagamento: Long) {
        repository.deleteById(idPagamento);
    }

    fun buscarFormaPagamentoId(idPagamento: Long): FormaPagamento {
        var formaPagamento: Optional<FormaPagamento> = repository.findById(idPagamento);
        return formaPagamento.get();
    }
}