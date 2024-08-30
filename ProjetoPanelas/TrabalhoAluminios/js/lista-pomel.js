function pesquisarPomel(){
    var http = new XMLHttpRequest();
    http.open('POST', "http://localhost:8080/pomel/pesquisarDesc");
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
    var tabela = document.getElementById('tabelaPomel');
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
        var celMaterial = row.insertCell(2);
        var celAcoes = row.insertCell(3);
        var pomel = lista[i];

        celCodigo.innerHTML = pomel.id;
        celDescricao.innerHTML = pomel.descricao;
        celMaterial.innerHTML = pomel.material;
        celAcoes.innerHTML = '<button class="btn btn-warning" onclick="alterar('+pomel.id+')">Alterar</button> <button class="btn btn-danger" onclick="excluir('+pomel.id+')">Excluir</button>';
    }

}

function excluir(id){
    var http = new XMLHttpRequest();
    http.open('DELETE', "http://localhost:8080/pomel/" + id);
    http.setRequestHeader('Content-Type', "application/json; charset=UTF-8");
    http.onloadend = function(event){
        if(http.status == 200){
            excluirLinha(id);
        }
    }
    http.send();
}

function excluirLinha(idPomel){
    var tabela = document.getElementById("tabelaPomel");
    var qtd = tabela.rows.length - 1;

    for(let i = 0; i <= qtd; i++){
        if(tabela.rows[i].cells[0].innerHTML == idPomel){
            tabela.deleteRow(i);
            break;
        }
    }
}

function alterar(idPomel){
    window.location = 'cadastro-pomel.html?id=' + idPomel;
}