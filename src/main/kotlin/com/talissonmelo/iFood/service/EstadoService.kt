package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.model.Estado
import com.talissonmelo.iFood.repository.EstadoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EstadoService {

    @Autowired
    lateinit var repository: EstadoRepository;

    fun listarEstados(): List<Estado> {
        return repository.findAll();
    }

    fun cadastrarEstado(estado: Estado): Estado {
        return repository.save(estado);
    }
}