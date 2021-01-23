package com.talissonmelo.iFood.repository

import com.talissonmelo.iFood.model.FormaPagamento
import org.springframework.data.jpa.repository.JpaRepository

interface FormaPagamentoRepository: JpaRepository<FormaPagamento, Long> {
}