function onLoadCadastro(){
    buscarDiscos();
    buscarPomeis();
    onLoadAlterar();
}

function buscarDiscos(){
    let http =  new XMLHttpRequest();
    http.open('POST', "http://localhost:8080/disco/pesquisarDesc");
    http.setRequestHeader('Content-Type', "application/json; charset=UTF-8");
    http.onloadend = function(event){
        if(http.status == 200){
        let lista = JSON.parse(http.response);
        let inputDisco = document.getElementById('inputDisco');
        for(let i = 0; i < lista.length; i++){
            let disco = lista[i];
            let opt = document.createElement('option');
            opt.text = disco.descricao;
            opt.value = disco.id;
            inputDisco.add(opt);
        }
    }
    }
    http.send(' ');
}


function buscarPomeis(){
    let http =  new XMLHttpRequest();
    http.open('POST', "http://localhost:8080/pomel/pesquisarDesc");
    http.setRequestHeader('Content-Type', "application/json; charset=UTF-8");
    http.onloadend = function(event){
        if(http.status == 200){
        let lista = JSON.parse(http.response);
        let inputPomel = document.getElementById('inputPomel');
        for(let i = 0; i < lista.length; i++){
            let pomel = lista[i];
            let opt = document.createElement('option');
            opt.text = pomel.descricao;
            opt.value = pomel.id;
            inputPomel.add(opt);
        }
    }
    }
    http.send(' ');
}

function salvar(){
    var tampa = new Object();
    var disco = new Object();
    var pomel = new Object();

    tampa.descricao = inputDescricao.value;
    disco.id = inputDisco.value;
    pomel.id = inputPomel.value;
    tampa.disco = disco;
    tampa.pomel = pomel;
    let metodo = 'POST'
    if(inputCodigo.value != ''){
        tampa.id = inputCodigo.value;
        metodo = 'PUT';
    }
    var http = new XMLHttpRequest();
    http.open(metodo, 'http://localhost:8080/tampa');
    http.setRequestHeader('Content-Type', "application/json");
    var tampaJson = JSON.stringify(tampa);
    http.onloadend = function(event){
        var tp = JSON.parse(http.response);
        inputCodigo.value = tp.id;
        history.back();
    }
    http.send(tampaJson);
}

function buscarParaAlterar(id){
    let http = new XMLHttpRequest();
    let url = "http://localhost:8080/tampa/"+id;
    http.open('GET',url);
    http.setRequestHeader('Content-Type', "application/json;charset=UTF-8")
    http.onloadend = function(event){
        if(http.status == 200){
            let tampa = JSON.parse(http.response);
            inputCodigo.value = tampa.id;
            inputDescricao.value = tampa.descricao;
            inputDisco.value = tampa.disco.id;
            inputPomel.value = tampa.pomel.id;
        }
    }
    http.send();
}

function onLoadAlterar(){
    let querySearch = window.location.search;
    let urlParam = new URLSearchParams(querySearch);
    let id = urlParam.get('id');
    if(id != null){
        buscarParaAlterar(id);
    }

}


function voltar(){
    history.back();
}
