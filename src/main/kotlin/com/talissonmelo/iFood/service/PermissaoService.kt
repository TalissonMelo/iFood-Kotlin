package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.model.Permissao
import com.talissonmelo.iFood.repository.PermissaoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PermissaoService {

    @Autowired
    lateinit var repository: PermissaoRepository;

    fun listarPermissoes(): List<Permissao> {
        return repository.findAll();
    }

    fun cadastrarPermissao(permissao: Permissao): Permissao {
        return repository.save(permissao);
    }
}