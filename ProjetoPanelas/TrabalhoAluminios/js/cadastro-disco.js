function salvar(){
    var disco = new Object();
    disco.descricao = inputDescricao.value;
    disco.tamanho = inputTamanho.value;
    disco.espessura = inputEspessura.value;
    let metodo = 'POST'

    if(inputCodigo.value != ''){
        disco.id = inputCodigo.value;
        metodo = 'PUT';
    }
    var http = new XMLHttpRequest();
    http.open(metodo, 'http://localhost:8080/disco');
    http.setRequestHeader('Content-Type', "application/json");
    var discoJson = JSON.stringify(disco);
    http.onloadend = function(event){
        console.log(http.response);
        var disco = JSON.parse(http.response);
        inputCodigo.value = disco.id;
        history.back();
    }
    http.send(discoJson);
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
    http.open('GET', "http://localhost:8080/disco/" + id);
    http.setRequestHeader('Content-Type', "application/json; charset=UTF-8");
    http.onloadend = function(event){
        let disco = JSON.parse(http.response);
        inputCodigo.value = disco.id;
        inputDescricao.value = disco.descricao;
        inputTamanho.value = disco.tamanho;
        inputEspessura.value = disco.espessura;
    }
    http.send();
}


function voltar(){
    history.back();
}