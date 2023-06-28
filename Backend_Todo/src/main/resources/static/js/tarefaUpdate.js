"use strict"

let url = window.location.href;
let numero_da_tarefa = url.substring((url.indexOf("?")+1),url.length)

function retornaTarefa(numero){
    let urlupdate = "http://localhost:8080/Tarefas/" + numero
    return urlupdate;
    }




fetch(retornaTarefa(numero_da_tarefa))
    .then(i => {return i.json()})
            .then(i => {
                  return tarefaUpdate(i.id,i.titulo,i.tarefa,i.prioridade,i.situacao,i.inicio,i.deadline,i.concluida)
                    })
                    .then(t=>{
                        let prioridade
                        switch(t.prioridade){
                            case "Alta":
                                prioridade = 1
                                break
                            case "Normal":
                                prioridade = 2
                                break            
                            case "Baixa":
                                prioridade = 3
                                break            

                        }
                        document.getElementById("id_update").value = t.id
                        document.getElementById("titulo").value = t.titulo
                        document.getElementById("tarefa").value = t.tarefa
                        document.getElementById("prioridade").value = prioridade
                        document.getElementById("inicio").value = t.inicio
                        document.getElementById("deadline").value = t.deadline
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

function redireciona(){
    location.href="http://localhost:8080/"
}





