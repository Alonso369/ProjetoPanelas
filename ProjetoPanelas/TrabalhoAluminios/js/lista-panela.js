function pesquisarPanela(){
    var http = new XMLHttpRequest();
    http.open("POST", "http://localhost:8080/panela/pesquisarDesc");
    http.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
    var descricao = inputPesquisa.value;
    if(inputPesquisa.value == ''){
        descricao = ' ';
    }
    http.onloadend = function(event){
        var lista = JSON.parse(http.response);
        montarTable(lista);
    }
    http.send(descricao);
}

function montarTable(lista){
    var tabelaPanela = document.getElementById('tabelaPanela');
    var cont = tabelaPanela.rows.length - 1;
    for (let i = cont; i > 0; i--){
        tabelaPanela.deleteRow(i);
    }
    var cont = tabelaPanela.rows.length - 1;
    for(let i = 0; i < lista.length; i++){
        cont++;
        var row = tabelaPanela.insertRow(cont);
        var celCodigo = row.insertCell(0);
        var celDescricao = row.insertCell(1);
        var celDisco = row.insertCell(2);
        var celTampa = row.insertCell(3);
        var celAlca = row.insertCell(4);
        var celPreco = row.insertCell(5);
        var celAcoes = row.insertCell(6);
        var panela = lista[i];
        celCodigo.innerHTML = panela.id;
        celDescricao.innerHTML = panela.descricao;
        celDisco.innerHTML = panela.disco.descricao;
        celTampa.innerHTML = panela.tampa.descricao;
        celAlca.innerHTML = panela.alca.descricao;
        celPreco.innerHTML = panela.preco;
        celAcoes.innerHTML = '<button class="btn btn-warning" onclick="alterar('+panela.id+')">Alterar</button> <button class="btn btn-danger" onclick="excluir('+panela.id+')">Excluir</button>';
    }
}

function excluir(id) {
    var http = new XMLHttpRequest();
    var url = 'http://localhost:8080/panela/' + id;
    http.open('DELETE', url);
    http.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    http.onloadend = function(event){
        if(http.status == 200){
            excluirLinhaTable(id);
        }
    }
    http.send();
}

function excluirLinhaTable(idTampa){
    var tabelaPanela = document.getElementById('tabelaPanela');
    var qtd = tabelaPanela.rows.length - 1;
    for(let i = 0; i <= qtd; i++){
        if(tabelaPanela.rows[i].cells[0].innerHTML == idTampa){
            tabelaPanela.deleteRow(i);
            break;
        }
    }
}

function alterar(id){
    var url = 'cadastro-panela.html?id=' + id;
    window.location = url;
}

