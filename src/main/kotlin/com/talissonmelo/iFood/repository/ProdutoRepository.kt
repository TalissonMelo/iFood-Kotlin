package com.talissonmelo.iFood.repository

import com.talissonmelo.iFood.model.Produto
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository: JpaRepository<Produto, Long> {
}