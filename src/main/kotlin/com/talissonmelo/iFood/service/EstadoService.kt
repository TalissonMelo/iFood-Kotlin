package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.model.Estado
import com.talissonmelo.iFood.repository.EstadoRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EstadoService constructor( @Autowired var repository: EstadoRepository) {

    fun listarEstados(): List<Estado> {
        return repository.findAll();
    }

    fun buscarEstadoId(idEstado: Long) : Estado {
        return repository.findById(idEstado).get();
    }
}