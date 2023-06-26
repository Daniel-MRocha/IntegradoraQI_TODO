"use strict"

let url = window.location.href;
let numero_da_tarefa = url.substring((url.indexOf("?")+1),url.length)

function retornaTarefa(numero){
    let urlupdate = "http://localhost:8080/Tarefas/" + numero
    return urlupdate;
    }


let tarefa;

let buscaTarefa = fetch(retornaTarefa(numero_da_tarefa))
let tarefa_processada = buscaTarefa.then(i => {return i.json()})
            .then(i => {
                tarefa = tarefaUpdate(i.id,i.titulo,i.tarefa,i.prioridade,i.situacao,i.inicio,i.deadline,i.concluida)
                    })

function tarefaUpdate(id,titulo,tarefa,prioridade,situacao,inicio,deadline,concluida){
     return { 
        id : id ,
        titulo : titulo,
        tarefa : tarefa,
        prioridade : prioridade,
        situacao : situacao,
        inicio : inicio,
        deadline : deadline,
        concluida : concluida
     }
}




function seed_form(t){
    document.getElementById("id_update").value = t.id
    document.getElementById("titulo").value = t.titulo
    document.getElementById("tarefa").value = t.tarefa
    document.getElementById("prioridade").value = t.prioridade
    document.getElementById("inicio").value = t.inicio
    document.getElementById("deadline").value = t.deadline
}


seed_form(tarefa);