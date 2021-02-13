package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.model.Permissao
import com.talissonmelo.iFood.repository.PermissaoRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PermissaoService constructor( @Autowired var repository: PermissaoRepository) {

    fun listarPermissoes(): List<Permissao> {
        return repository.findAll();
    }

    fun buscarPermissaoId(idPermissao: Long): Permissao {
        return repository.findById(idPermissao).get();
    }

    fun cadastrarPermissao(permissao: Permissao): Permissao {
        return repository.save(permissao);
    }

    fun deletarPermissaoId(idPermissao: Long) {
        repository.deleteById(idPermissao);
    }

    fun atualiarPermissao(idPermissao: Long, permissao: Permissao) : Permissao {
        var permissaoAtualizar : Permissao = buscarPermissaoId(idPermissao);
        BeanUtils.copyProperties(permissao, permissaoAtualizar, "id");
        return repository.save(permissaoAtualizar);
    }
}