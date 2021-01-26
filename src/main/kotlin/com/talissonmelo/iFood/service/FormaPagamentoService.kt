package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.model.FormaPagamento
import com.talissonmelo.iFood.repository.FormaPagamentoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FormaPagamentoService {

    @Autowired
    lateinit var repository: FormaPagamentoRepository;

    fun listarPagamentos(): List<FormaPagamento> {
        return repository.findAll();
    }

    fun cadastrarPagamento(pagamento: FormaPagamento): FormaPagamento {
        return repository.save(pagamento);
    }
}