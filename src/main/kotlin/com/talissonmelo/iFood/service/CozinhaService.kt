package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.model.Cozinha
import com.talissonmelo.iFood.repository.CozinhaRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CozinhaService constructor( @Autowired var repository: CozinhaRepository){

    fun listarCozinhas(): List<Cozinha> {
        return repository.findAll();
    }

    fun existeCozinha(nome: String): Boolean {
        return repository.existsByNome(nome);
    }

    fun cadastrarCozinha(cozinha: Cozinha): Cozinha {
        return repository.save(cozinha);
    }

    fun buscarCozinhaId(idCozinha: Long): Cozinha {
        return repository.findById(idCozinha).get();
    }

    fun atualizarCozinha(idCozinha: Long ,cozinha: Cozinha): Cozinha {
        var cozinhaAtualizada: Cozinha = buscarCozinhaId(idCozinha);
        BeanUtils.copyProperties(cozinha,cozinhaAtualizada, "id");
        return repository.save(cozinhaAtualizada);
    }

    fun deletarCozinha(idCozinha: Long) {
        repository.deleteById(idCozinha);
    }
}