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

                        let inicio = document.getElementById("inicio")
                        inicio.value = t.inicio
                          
                        let deadline = document.getElementById("deadline")
                                deadline.onchange = () => {
                                    let ini = inicio.value
                                    let dea = deadline.value 
                                    let resultado = validaData(ini,dea)
                                        if(resultado==true){
                                            deadline.value=null
                                        }
                                }   
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
    location.href="http://localhost:8080/tarefaPainel.html"
}

function recarrega(){
    location.href="http://localhost:8080/html/updateTarefa.html?" + numero_da_tarefa
}

function validaData(data1,data2){ 

    let transD1 = data1.split("-")
    let transD2 = data2.split("-")

    let d1 = new Date(transD1[0], transD1[1] - 1, transD1[2])
    let d2 = new Date(transD2[0], transD2[1] - 1, transD2[2])
    if(d1>d2){
        alert("O deadline deve ser igual posterior a data inicio da tarefa")
        return true
    }else{
        return false
    }
}
