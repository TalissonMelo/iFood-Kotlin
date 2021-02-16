package com.talissonmelo.iFood.repository

import com.talissonmelo.iFood.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario , Long> {
}