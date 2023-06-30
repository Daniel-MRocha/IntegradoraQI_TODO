"use strict"

let listaDeTarefas = new Array();


let urlBackend = "http://localhost:8080/Tarefas"
let dados = fetch(urlBackend)

dados.then(dados =>{return dados.json()})
.then(d=>{
                [...d].forEach(ele=>{
                listaDeTarefas.push(constroiTarefa(ele))
             }) 
    })


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

const endPointDelete  = "http://localhost:8080/Tarefas/del/"
const endPointConclui = "http://localhost:8080/Tarefas/conc/"

let tarefa_para_update;
const urlUpdate = "http://localhost:8080/html/updateTarefa.html"

async function deleta(num){
    let url = endPointDelete + num
    let request = new XMLHttpRequest()
    request.open("GET",url,false)
    request.setRequestHeader("content-type","text/plain")
    request.send()
}

async function conclui(num){
    let url = endPointConclui + num
    let request = new XMLHttpRequest()
    request.open("GET",url,false)
    request.setRequestHeader("content-type","text/plain")
    request.send()
}



    function exibeTarefas(){

    let containerPai = document.querySelector("#visualizar")
  

    listaDeTarefas.forEach(trf =>{
            let caixa = document.createElement("div")
            caixa.className = "boxTarefa"
                let caixaBotoes = document.createElement("span")
                caixaBotoes.className="boxBotoes"
            
            let caixaTitulo = document.createElement("span")
            caixaTitulo.className = "boxTitulo"
            caixaTitulo.innerHTML=trf.titulo

            let conteudo = document.createElement("div")
            conteudo.className = "boxConteudo"
                conteudo.innerHTML = trf.tarefa

            let datas = document.createElement("span")
            datas.className = "boxDatas"
                if(trf.concluida == null){
                    datas.innerHTML = "Inicia: " + trf.inicio + "   Termina: " + trf.deadline  
                } else {
                    datas.innerHTML = "Inicia: " + trf.inicio + "   Termina: " + trf.deadline +  "  Concluida: " + trf.concluida
                }

            let situacao = document.createElement("span")
                    if(trf.concluida != null){
                        situacao.className="onConcluida"
                        situacao.innerHTML="Concluida"
                         
                    }else if(trf.situacao=="Expirada"){
                        situacao.className="onExpirada"
                        situacao.innerHTML="Expirada"
                    }else{
                        situacao.className="onAberta"
                        situacao.innerHTML="Em andamento"
                    } 

            let prioridade = document.createElement("span")
            prioridade.className = "boxPrioridade"
            prioridade.innerHTML = "Prioridade: " + trf.prioridade

            let delbutton = document.createElement("button")
            delbutton.className = "deleteB"
            delbutton.value = trf.id
            delbutton.onclick = () =>{
               let del = deleta(trf.id);
                del.then(() => {return location.href="http://localhost:8080/html/deleteOk.html"})
            }
            delbutton.innerHTML="Deletar"
            

            let upbutton = document.createElement("button")
            upbutton.className = "updateB"
            upbutton.value = trf.id
            upbutton.onclick = () =>{
                tarefa_para_update=trf.id
                location.href = urlUpdate
                window.location = urlUpdate + "?" + trf.id
            }
            upbutton.innerHTML="Update"
        

            
            let concbutton = document.createElement("button")
            concbutton.className = "concluirB"
            concbutton.value = trf.id
            concbutton.onclick = (()=>{
                let conc = conclui(trf.id)
                conc.then(()=> {return location.href="http://localhost:8080/html/concluidaOk.html"})
            })
            concbutton.innerHTML="Concluir"
            
               

    containerPai.insertAdjacentElement("afterbegin",caixa)
    caixa.insertAdjacentElement("afterbegin",caixaTitulo)
    caixa.insertAdjacentElement("beforeend",conteudo)
    caixa.insertAdjacentElement("beforeend",datas)
    caixa.insertAdjacentElement("beforeend",prioridade)
    caixa.insertAdjacentElement("beforeend",situacao)
            caixa.insertAdjacentElement("beforeend",caixaBotoes)
                caixaBotoes.insertAdjacentElement("afterbegin",delbutton)
                caixaBotoes.insertAdjacentElement("beforeend",upbutton)
                if(trf.concluida==null){
                    caixaBotoes.insertAdjacentElement("beforeend",concbutton)
                } 
            })
}

setTimeout(() => exibeTarefas(),1200)



