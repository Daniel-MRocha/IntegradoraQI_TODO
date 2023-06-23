"use strict"

let listaDeTarefas = new Array();


let urlBackend = "http://localhost:8080/Tarefas"
let dados = fetch(urlBackend)

dados.then(dados =>{return dados.json()})
.then(d=>{
                [...d].forEach(ele=>{
                listaDeTarefas.push(constroiTarefa(ele))
             }) 
    });


//Factory de tarefa
function constroiTarefa(obj){
    return tarefa(obj.id,obj.titulo , obj.tarefa,obj.prioridade, obj.situacao, obj.inicio,obj.deadline,obj.concluida)
}

//construtor da tarefa
function tarefa(tid,tit,tar,pri,sit,ini,dln,cld){
    return {
        id : tid,
        titulo : tit,
        tarefa : tar,
        prioridade : pri,
        situacao : sit,
        inicio : ini,
        deadline : dln,
        concluida : cld
    }
}

function exibeTarefas(){

    let containerPai = document.querySelector("#visualizar")
  

    listaDeTarefas.forEach(trf =>{
            let caixa = document.createElement("div")
            caixa.className = "boxTarefa"
            
            let caixaTitulo = document.createElement("span")
            caixaTitulo.className = "boxTitulo"
            caixaTitulo.innerHTML=trf.titulo

            let conteudo = document.createElement("div")
            conteudo.className = "boxConteudo"
                conteudo.innerHTML = trf.tarefa

            let datas = document.createElement("span")
            datas.className = "boxDatas"
                datas.innerHTML = "Inicia: " + trf.inicio + " Termina: " + trf.deadline + " Concluida: " + trf.concluida 
            

    containerPai.insertAdjacentElement("afterbegin",caixa)
    caixa.insertAdjacentElement("afterbegin",caixaTitulo)
    caixa.insertAdjacentElement("beforeend",conteudo)
    caixa.insertAdjacentElement("beforeend",datas)
    })
}


