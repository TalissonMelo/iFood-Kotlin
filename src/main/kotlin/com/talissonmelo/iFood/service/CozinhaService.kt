package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.model.Cozinha
import com.talissonmelo.iFood.repository.CozinhaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CozinhaService {

    @Autowired
    lateinit var repository: CozinhaRepository;

    fun listarCozinhas(): List<Cozinha> {
        return repository.findAll();
    }

    fun cadastrarCozinha(cozinha: Cozinha): Cozinha {
        return repository.save(cozinha);
    }
}