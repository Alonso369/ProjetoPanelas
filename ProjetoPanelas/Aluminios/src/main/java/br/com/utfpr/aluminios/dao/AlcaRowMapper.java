package br.com.utfpr.aluminios.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.utfpr.aluminios.model.Alca;

public class AlcaRowMapper implements RowMapper<Alca>{

	@Override
	public Alca mapRow(ResultSet rs, int rowNum) throws SQLException {
		Alca alca = new Alca();
		alca.setId(rs.getLong("id"));
		alca.setDescricao(rs.getString("descricao"));
		return alca;
	}
	
}
