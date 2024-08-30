function pesquisarAlca(){
    var http = new XMLHttpRequest();
    http.open('POST', "http://localhost:8080/alca/pesquisarDesc");
    http.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
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
    var tabela = document.getElementById('tabelaAlca');
    var cont = tabela.rows.length - 1;
    for(let i = cont; i > 0; i--){
        tabela.deleteRow(i);
    }
    var cont = tabela.rows.length - 1;
    for(let i = 0; i < lista.length; i++){
        cont++;
        var row = tabela.insertRow(cont);
        var celCodigo = row.insertCell(0);
        var celDescricao = row.insertCell(1);
        var celAcoes = row.insertCell(2);
        var alca = lista[i];

        celCodigo.innerHTML = alca.id;
        celDescricao.innerHTML = alca.descricao;
        celAcoes.innerHTML = '<button class="btn btn-warning" onclick="alterar('+alca.id+')">Alterar</button> <button class="btn btn-danger" onclick="excluir('+alca.id+')">Excluir</button>';
    }

}

function excluir(id){
    var http = new XMLHttpRequest();
    http.open('DELETE', "http://localhost:8080/alca/" + id);
    http.setRequestHeader('Content-Type', "application/json; charset=UTF-8");
    http.onloadend = function(event){
        if(http.status == 200){
            excluirLinha(id);
        }
    }
    http.send();
}

function excluirLinha(idAlca){
    var tabela = document.getElementById("tabelaAlca");
    var qtd = tabela.rows.length - 1;

    for(let i = 0; i <= qtd; i++){
        if(tabela.rows[i].cells[0].innerHTML == idAlca){
            tabela.deleteRow(i);
            break;
        }
    }
}

function alterar(idAlca){
    window.location = 'cadastro-alca.html?id=' + idAlca;
}