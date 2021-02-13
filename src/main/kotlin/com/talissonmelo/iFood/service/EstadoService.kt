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

    fun cadastrarEstado(estado: Estado): Estado {
        return repository.save(estado);
    }

    fun buscarEstadoId(idEstado: Long) : Estado {
        return repository.findById(idEstado).get();
    }

    fun deletarEstadoId(idEstado: Long) {
        repository.deleteById(idEstado);
    }

    fun atualizarEstado(idEstado: Long, estado: Estado): Estado {
        var estadoAtulizar : Estado = buscarEstadoId(idEstado);
        BeanUtils.copyProperties(estado, estadoAtulizar, "id");
        return cadastrarEstado(estadoAtulizar);
    }
}