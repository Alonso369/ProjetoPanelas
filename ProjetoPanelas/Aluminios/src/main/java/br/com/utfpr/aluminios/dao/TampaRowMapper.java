package br.com.utfpr.aluminios.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.utfpr.aluminios.model.Disco;
import br.com.utfpr.aluminios.model.Pomel;
import br.com.utfpr.aluminios.model.Tampa;

public class TampaRowMapper implements RowMapper<Tampa>{

	private boolean alterar = false;
	
	public TampaRowMapper(boolean alterar) {
		this.alterar = alterar;
	}
	
	public TampaRowMapper() {
	}
	
	@Override
	public Tampa mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tampa tampa = new Tampa();
		Disco disco = new Disco();
		Pomel pomel = new Pomel();
		tampa.setId(rs.getLong("id"));
		tampa.setDescricao(rs.getString("descricao"));
		disco.setId(rs.getLong("idDisco"));
		pomel.setId(rs.getLong("idPomel"));
		if(alterar) {
			pomel.setDescricao(rs.getString(10));
			disco.setDescricao(rs.getString(6));
		}
		tampa.setDisco(disco);
		tampa.setPomel(pomel);		
		return tampa;
	}
	
}
