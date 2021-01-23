package com.talissonmelo.iFood.repository

import com.talissonmelo.iFood.model.Cidade
import org.springframework.data.jpa.repository.JpaRepository

interface CidadeRepository: JpaRepository<Cidade, Long> {
}