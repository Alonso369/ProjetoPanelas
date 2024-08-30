function pesquisarDisco(){
    var http = new XMLHttpRequest();
    var url = "http://localhost:8080/disco/pesquisarDesc";
    http.open("POST", url);
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
    var tabela = document.getElementById('tabelaDisco');
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
        var celTamanho = row.insertCell(2);
        var celEspessura = row.insertCell(3);
        var celAcoes = row.insertCell(4);
        var disco = lista[i];

        celCodigo.innerHTML = disco.id;
        celDescricao.innerHTML = disco.descricao;
        celTamanho.innerHTML = disco.tamanho;
        celEspessura.innerHTML = disco.espessura;
        celAcoes.innerHTML = '<button class="btn btn-warning " onclick="alterar('+disco.id+')">Alterar</button> <button class="btn btn-danger" onclick="excluir('+disco.id+')">Excluir</button>';
    }
}

function excluir(id){
    var http = new XMLHttpRequest();
    http.open('DELETE', 'http://localhost:8080/disco/' + id);
    http.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    http.onloadend = function(event){
        if(http.status == 200){
            excluirLinha(id);
        } else if(http.status == 500) {
            alert("O disco está sendo usado e não pode ser excluido");
        }
    }
    http.send();
}

function excluirLinha(idDisco){
    var tabela = document.getElementById("tabelaDisco");
    var qtd = tabela.rows.length - 1;
    for(let i = 0; i <= qtd; i++){
        if(tabela.rows[i].cells[0].innerHTML == idDisco){
            tabela.deleteRow(i);
            break;
        }
    }
}

function alterar(idDisco){
    window.location = 'cadastro-disco.html?id=' + idDisco;
}