package com.qi.integradoraDS.Backend_Todo.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dummy")
public class dummycon {

    @Autowired
    private dummyserv ds;

    @GetMapping
    public List<dummy> listadummies(){
        return ds.todosdummy();
    }

    @PostMapping
    public void grava(@RequestParam int num, @RequestParam String nome){
        dummy du = new dummy();
        du.setNome(nome);
        du.setNum(num);
        ds.insere(du);
    }
}
