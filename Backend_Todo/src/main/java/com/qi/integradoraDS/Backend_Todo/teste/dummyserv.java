package com.qi.integradoraDS.Backend_Todo.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dummyserv {

    @Autowired
    private dummyrep dr;

    public List<dummy> todosdummy(){
        return  dr.findAll();
    }

    public void insere(dummy d){
        dr.save(d);
    }
}
