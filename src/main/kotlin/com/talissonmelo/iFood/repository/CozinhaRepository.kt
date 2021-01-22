package com.talissonmelo.iFood.repository

import com.talissonmelo.iFood.model.Cozinha
import org.springframework.data.jpa.repository.JpaRepository

interface CozinhaRepository: JpaRepository<Cozinha, Long> {
}