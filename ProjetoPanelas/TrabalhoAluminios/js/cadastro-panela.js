function onLoadCadastro(){
    buscarDiscos();
    buscarTampas();
    buscarAlcas();
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


function buscarTampas(){
    let http =  new XMLHttpRequest();
    http.open('POST', "http://localhost:8080/tampa/pesquisarDesc");
    http.setRequestHeader('Content-Type', "application/json; charset=UTF-8");
    http.onloadend = function(event){
        if(http.status == 200){
        let lista = JSON.parse(http.response);
        let inputTampa = document.getElementById('inputTampa');
        for(let i = 0; i < lista.length; i++){
            let tampa = lista[i];
            let opt = document.createElement('option');
            opt.text = tampa.descricao;
            opt.value = tampa.id;
            inputTampa.add(opt);
        }
    }
    }
    http.send(' ');
}

function buscarAlcas(){
    let http =  new XMLHttpRequest();
    http.open('POST', "http://localhost:8080/alca/pesquisarDesc");
    http.setRequestHeader('Content-Type', "application/json; charset=UTF-8");
    http.onloadend = function(event){
        if(http.status == 200){
        let lista = JSON.parse(http.response);
        let inputAlca = document.getElementById('inputAlca');
        for(let i = 0; i < lista.length; i++){
            let alca = lista[i];
            let opt = document.createElement('option');
            opt.text = alca.descricao;
            opt.value = alca.id;
            inputAlca.add(opt);
        }
    }
    }
    http.send(' ');
}

function salvar(){
    var panela = new Object();
    var tampa = new Object();
    var disco = new Object();
    var alca = new Object();


    panela.descricao = inputDescricao.value;
    disco.id = inputDisco.value;
    tampa.id = inputTampa.value;
    alca.id = inputAlca.value;
    panela.disco = disco;
    panela.tampa = tampa;
    panela.alca = alca;
    panela.preco = inputPreco.value;
    let metodo = 'POST'
    if(inputCodigo.value != ''){
        panela.id = inputCodigo.value;
        metodo = 'PUT';
    }
    var http = new XMLHttpRequest();
    http.open(metodo, 'http://localhost:8080/panela');
    http.setRequestHeader('Content-Type', "application/json");
    var panelaJson = JSON.stringify(panela);
    http.onloadend = function(event){
        var pn = JSON.parse(http.response);
        inputCodigo.value = pn.id;
        history.back();
    }
    http.send(panelaJson);
}

function buscarParaAlterar(id){
    let http = new XMLHttpRequest();
    let url = "http://localhost:8080/panela/"+id;
    http.open('GET',url);
    http.setRequestHeader('Content-Type', "application/json;charset=UTF-8")
    http.onloadend = function(event){
        if(http.status == 200){
            let panela = JSON.parse(http.response);
            inputCodigo.value = panela.id;
            inputDescricao.value = panela.descricao;
            inputDisco.value = panela.disco.id;
            inputTampa.value = panela.tampa.id;
            inputAlca.value = panela.alca.id;
            inputPreco.value = panela.preco;
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
