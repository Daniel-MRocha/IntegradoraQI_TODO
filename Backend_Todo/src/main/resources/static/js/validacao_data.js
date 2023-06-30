"use strict"

function validaData(){ 

    let data1 = document.querySelector("#inicio").value
    let data2 = document.querySelector("#deadline").value

    let htmlData2 = document.querySelector("#deadline")

    let transD1 = data1.split("-")
    let transD2 = data2.split("-")

    let d1 = new Date(transD1[0], transD1[1] - 1, transD1[2])
    let d2 = new Date(transD2[0], transD2[1] - 1, transD2[2])
    if(d1>d2){
        alert("O deadline deve ser igual ou posterior a data inicio da tarefa")
        htmlData2.value = null
        return true
    }else{
        return false
    }}