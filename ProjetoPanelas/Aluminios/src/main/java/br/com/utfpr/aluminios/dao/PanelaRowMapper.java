package br.com.utfpr.aluminios.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.utfpr.aluminios.model.Alca;
import br.com.utfpr.aluminios.model.Disco;
import br.com.utfpr.aluminios.model.Panela;
import br.com.utfpr.aluminios.model.Tampa;

public class PanelaRowMapper implements RowMapper<Panela>{
	
	private boolean alterar = false;

	public PanelaRowMapper() {
		
	}
	
	public PanelaRowMapper(boolean alterar) {
		this.alterar = alterar;
	}
	
	@Override
	public Panela mapRow(ResultSet rs, int rowNum) throws SQLException {
		Panela panela = new Panela();
		Disco disco = new Disco();
		Tampa tampa = new Tampa();
		Alca alca = new Alca();		
		panela.setId(rs.getLong("id"));
		panela.setDescricao(rs.getString("descricao"));
		disco.setId(rs.getLong("idDisco"));
		tampa.setId(rs.getLong("idTampa"));
		alca.setId(rs.getLong("idAlca"));
		if(alterar) {
			disco.setDescricao(rs.getString(8));
			tampa.setDescricao(rs.getString(12));
			alca.setDescricao(rs.getString(16));
		}
		panela.setDisco(disco);
		panela.setTampa(tampa);
		panela.setAlca(alca);
		panela.setPreco(rs.getDouble("preco"));
		return panela;
	}

}
