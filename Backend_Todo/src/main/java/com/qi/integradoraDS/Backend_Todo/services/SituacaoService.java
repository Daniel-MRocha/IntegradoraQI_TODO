package com.qi.integradoraDS.Backend_Todo.services;


import com.qi.integradoraDS.Backend_Todo.entities.Situacao;
import com.qi.integradoraDS.Backend_Todo.repositories.SituacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SituacaoService {

    @Autowired
    private SituacaoRepository sitRpy;

    public Situacao buscaSit(int numero){
        var aux = sitRpy.findById(numero);
        if(aux.isPresent()) return aux.get();
        return null;
    }
}
