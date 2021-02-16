package com.talissonmelo.iFood.repository

import com.talissonmelo.iFood.model.Grupo
import org.springframework.data.jpa.repository.JpaRepository

interface GrupoRepository : JpaRepository<Grupo, Long> {
}