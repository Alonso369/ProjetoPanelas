function salvar(){
    var alca = new Object();
    alca.descricao = inputDescricao.value;

    let metodo = 'POST';
    if(inputCodigo.value != ''){
        alca.id = inputCodigo.value;
        metodo = 'PUT'
    }

    var http = new XMLHttpRequest();
    http.open(metodo, "http://localhost:8080/alca");
    http.setRequestHeader('Content-Type', "application/json");
    var alcaJson = JSON.stringify(alca);
    http.onloadend = function(event){
        console.log(http.response);
        var ac = JSON.parse(http.response);
        inputCodigo.value = ac.id;
        history.back();
    }
    http.send(alcaJson);
}


function onLoadCadastro(){
    let querySearch = window.location.search;
    let urlParam = new URLSearchParams(querySearch);
    let id = urlParam.get('id');
    if(id != null){
        buscarAlterar(id);
    }
}

function buscarAlterar(id){
    let http = new XMLHttpRequest();
    http.open('GET', "http://localhost:8080/alca/" + id);
    http.setRequestHeader('Content-Type', "application/json; charset=UTF-8");
    http.onloadend = function(event){
        let alca = JSON.parse(http.response);
        inputCodigo.value = alca.id;
        inputDescricao.value = alca.descricao;
    }
    http.send();
}


function voltar(){
    history.back();
}