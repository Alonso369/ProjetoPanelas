function pesquisarTampa(){
    var http = new XMLHttpRequest();
    http.open("POST", "http://localhost:8080/tampa/pesquisarDesc");
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
    var tabelaTampa = document.getElementById('tabelaTampa');
    var cont = tabelaTampa.rows.length - 1;
    for (let i = cont; i > 0; i--){
        tabelaTampa.deleteRow(i);
    }
    var cont = tabelaTampa.rows.length - 1;
    for(let i = 0; i < lista.length; i++){
        cont++;
        var row = tabelaTampa.insertRow(cont);
        var celCodigo = row.insertCell(0);
        var celDescricao = row.insertCell(1);
        var celDisco = row.insertCell(2);
        var celPomel = row.insertCell(3);
        var celAcoes = row.insertCell(4);
        var tampa = lista[i];
        celCodigo.innerHTML = tampa.id;
        celDescricao.innerHTML = tampa.descricao;
        celDisco.innerHTML = tampa.disco.descricao;
        celPomel.innerHTML = tampa.pomel.descricao;
        celAcoes.innerHTML = '<button class="btn btn-warning" onclick="alterar('+tampa.id+')">Alterar</button> <button class="btn btn-danger" onclick="excluir('+tampa.id+')">Excluir</button>';
    }
}

function excluir(id) {
    var http = new XMLHttpRequest();
    var url = 'http://localhost:8080/tampa/' + id;
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
    var tabelaTampa = document.getElementById('tabelaTampa');
    var qtd = tabelaTampa.rows.length - 1;
    for(let i = 0; i <= qtd; i++){
        if(tabelaTampa.rows[i].cells[0].innerHTML == idTampa){
            tabelaTampa.deleteRow(i);
            break;
        }
    }
}

function alterar(id){
    var url = 'cadastro-tampa.html?id=' + id;
    window.location = url;
}

