package br.com.sistran.aluminios.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.sistran.aluminios.model.Disco;

public class DiscoRowMapper implements RowMapper<Disco> {

	@Override
	public Disco mapRow(ResultSet rs, int rowNum) throws SQLException {
		Disco disco = new Disco();
		disco.setId(rs.getLong("id"));
		disco.setDescricao(rs.getString("descricao"));
		disco.setTamanho(rs.getDouble("tamanho"));
		disco.setEspessura(rs.getDouble("espessura"));
		return disco;	
	}
	
}
