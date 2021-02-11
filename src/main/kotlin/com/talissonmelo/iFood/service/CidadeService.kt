package com.talissonmelo.iFood.service

import com.talissonmelo.iFood.model.Cidade
import com.talissonmelo.iFood.repository.CidadeRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CidadeService {

    @Autowired
    lateinit var repository: CidadeRepository

    fun listarCidades(): List<Cidade>{
        return repository.findAll();
    }

    fun cadastrarCidade(cidade: Cidade) : Cidade {
        return repository.save(cidade);
    }

    fun deletarCidade(idCidade: Long) {
        repository.deleteById(idCidade);
    }

    fun atualizarCidade(idCidade:Long ,cidade: Cidade) : Cidade {
        var cidadeUpdate: Cidade = repository.findById(idCidade).get();
        BeanUtils.copyProperties(cidade, cidadeUpdate , "id");
        return repository.save(cidadeUpdate);
    }

    fun buscarCidadesNome(nome: String) : List<Cidade> {
        return repository.findByNomeLike( nome + "%");
    }

    fun buscarCidadeNome(nome: String) : Cidade {
        return repository.findByNome(nome).get();
    }

    fun buscarCidadeId(idCidade: Long): Cidade {
        return repository.findById(idCidade).get();
    }
}