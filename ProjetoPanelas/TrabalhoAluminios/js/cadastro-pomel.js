function salvar(){
    debugger;
    var pomel = new Object();
    pomel.descricao = inputDescricao.value;
    pomel.material = inputMaterial.value;
    let metodo = 'POST';
    if(inputCodigo.value != ''){
        pomel.id = inputCodigo.value;
        metodo = 'PUT'
    }

    var http = new XMLHttpRequest();
    http.open(metodo, "http://localhost:8080/pomel");
    http.setRequestHeader('Content-Type', "application/json");
    var pomelJson = JSON.stringify(pomel);
    http.onloadend = function(event){
        console.log(http.response);
        var pm = JSON.parse(http.response);
        inputCodigo.value = pm.id;
        history.back();
    }
    http.send(pomelJson);
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
    http.open('GET', "http://localhost:8080/pomel/" + id);
    http.setRequestHeader('Content-Type', "application/json; charset=UTF-8");
    http.onloadend = function(event){
        let pomel = JSON.parse(http.response);
        inputCodigo.value = pomel.id;
        inputDescricao.value = pomel.descricao;
        inputMaterial.value = pomel.material;
    }
    http.send();
}


function voltar(){
    history.back();
}