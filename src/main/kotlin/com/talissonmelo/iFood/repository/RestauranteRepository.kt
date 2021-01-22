package com.talissonmelo.iFood.repository

import com.talissonmelo.iFood.model.Restaurante
import org.springframework.data.jpa.repository.JpaRepository

interface RestauranteRepository : JpaRepository<Restaurante, Long> {
}