package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.model.FormaPagamento
import com.talissonmelo.iFood.repository.FormaPagamentoRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FormaPagamentoService constructor( @Autowired var repository: FormaPagamentoRepository) {

    fun listarPagamentos(): List<FormaPagamento> {
        return repository.findAll();
    }

    fun cadastrarPagamento(pagamento: FormaPagamento): FormaPagamento {
        return repository.save(pagamento);
    }

    fun buscarPagamentoId(idPagamento: Long) : FormaPagamento {
        return repository.findById(idPagamento).get();
    }

    fun deletarPagamentoId(idPagamento: Long) {
        repository.deleteById(idPagamento);
    }

    fun atualizarPagamento(idPagamento: Long, pagamento: FormaPagamento): FormaPagamento{
        var pagamentoAtualizar : FormaPagamento = buscarPagamentoId(idPagamento);
        BeanUtils.copyProperties(pagamento,pagamentoAtualizar, "id");
        return cadastrarPagamento(pagamentoAtualizar);
    }
}