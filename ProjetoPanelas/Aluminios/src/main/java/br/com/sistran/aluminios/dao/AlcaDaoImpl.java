package br.com.sistran.aluminios.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.sistran.aluminios.model.Alca;


@Repository
public class AlcaDaoImpl extends AbstractDaoImpl<Alca>{

	@Override
	public Alca inserir(Alca obj) throws Exception {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		insert.setColumnNames(Arrays.asList("descricao"));
		insert.setTableName("alca");
		insert.setGeneratedKeyName("id");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("descricao", obj.getDescricao());
		Number num = insert.executeAndReturnKey(param);
		obj.setId(num.longValue());
		return obj;
	}

	@Override
	public Alca alterar(Alca obj) throws Exception {
		String sql = "UPDATE ALCA SET DESCRICAO = ? WHERE ID = ?";
		int result = jdbc.update(sql, obj.getDescricao(), obj.getId());
		if(result > 0) {
			return obj;
		}
		return null;
	}

	@Override
	public boolean excluir(Alca obj) throws Exception {
		String sql = "DELETE FROM ALCA WHERE ID = ?";
		int result = jdbc.update(sql, obj.getId());
		if(result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Alca buscarPorCodigo(Long id) throws Exception {
		String sql = "SELECT * FROM ALCA WHERE ID = ?";
		return jdbc.queryForObject(sql, new AlcaRowMapper(), id);
	}
	
	public List<Alca> pesquisarDesc(String descricao) throws Exception{
		String sql = "SELECT * FROM ALCA WHERE UPPER(DESCRICAO) LIKE ?";
		descricao = "%" + descricao.toUpperCase().trim() + "%";
		return jdbc.query(sql, new AlcaRowMapper(), descricao);
	}
	
	
	
	
	

}
