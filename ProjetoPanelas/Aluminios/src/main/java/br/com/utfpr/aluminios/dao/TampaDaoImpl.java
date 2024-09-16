package br.com.utfpr.aluminios.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.utfpr.aluminios.model.Tampa;

@Repository
public class TampaDaoImpl extends AbstractDaoImpl<Tampa>{

	@Override
	public Tampa inserir(Tampa obj) throws Exception {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		insert.setColumnNames(Arrays.asList("descricao", "idPomel", "idDisco"));
		insert.setTableName("tampa");
		insert.setGeneratedKeyNames("id");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("descricao", obj.getDescricao());
		param.addValue("idPomel", obj.getPomel().getId());
		param.addValue("idDisco", obj.getDisco().getId());
		Number num = insert.executeAndReturnKey(param);
		obj.setId(num.longValue());
		return obj;
	}

	@Override
	public Tampa alterar(Tampa obj) throws Exception {
		String sql = "UPDATE TAMPA SET DESCRICAO = ?, IDPOMEL = ?, IDDISCO = ? WHERE ID = ?";
		int result = jdbc.update(sql, obj.getDescricao(), obj.getPomel().getId(), obj.getDisco().getId(), obj.getId());
		if(result > 0) {
			return obj;
		}
		return null;
	}

	@Override
	public boolean excluir(Tampa obj) throws Exception {
		String sql = "DELETE FROM TAMPA WHERE ID = ?";
		int result = jdbc.update(sql, obj.getId());
		if(result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Tampa buscarPorCodigo(Long id) throws Exception {
		String sql = "SELECT * FROM TAMPA WHERE ID = ?";
		return jdbc.queryForObject(sql, new TampaRowMapper(), id);
	}
	
	public List<Tampa> pesquisarDesc(String descricao) throws Exception{
		String sql = "SELECT * FROM TAMPA "
				+ "JOIN DISCO ON TAMPA.IDDISCO = DISCO.ID "
				+ "JOIN POMEL ON TAMPA.IDPOMEL = POMEL.ID "
				+ "WHERE UPPER(TAMPA.DESCRICAO) LIKE ?";
		descricao = "%" + descricao.toUpperCase().trim() + "%";
		return jdbc.query(sql, new TampaRowMapper(true), descricao);
	} 
	
}
