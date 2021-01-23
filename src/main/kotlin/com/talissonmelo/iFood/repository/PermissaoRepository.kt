package com.talissonmelo.iFood.repository

import com.talissonmelo.iFood.model.Permissao
import org.springframework.data.jpa.repository.JpaRepository

interface PermissaoRepository: JpaRepository<Permissao, Long> {
}