package br.com.sistran.aluminios.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.sistran.aluminios.model.Pomel;

public class PomelRowMapper implements RowMapper<Pomel>{
	@Override
	public Pomel mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pomel pomel = new Pomel();
		pomel.setId(rs.getLong("id"));
		pomel.setDescricao(rs.getString("descricao"));
		pomel.setMaterial(rs.getString("material"));
		return pomel;
	}
}
