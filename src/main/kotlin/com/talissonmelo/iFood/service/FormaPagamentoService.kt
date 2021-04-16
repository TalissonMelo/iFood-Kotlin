package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.repository.FormaPagamentoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class FormaPagamentoService constructor(@Autowired var repository: FormaPagamentoRepository) {

    @Transactional
    fun deletarFormaPagamento(idPagamento: Long) {
        repository.deleteById(idPagamento);
    }
}