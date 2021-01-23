package com.talissonmelo.iFood.repository

import com.talissonmelo.iFood.model.Estado
import org.springframework.data.jpa.repository.JpaRepository

interface EstadoRepository: JpaRepository<Estado, Long> {
}