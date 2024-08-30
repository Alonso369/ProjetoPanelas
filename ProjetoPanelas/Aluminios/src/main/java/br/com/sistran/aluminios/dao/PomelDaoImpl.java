package br.com.sistran.aluminios.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.sistran.aluminios.model.Pomel;

@Repository
public class PomelDaoImpl extends AbstractDaoImpl<Pomel>{

	@Override
	public Pomel inserir(Pomel obj) throws Exception {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		insert.setColumnNames(Arrays.asList("descricao", "material"));
		insert.setTableName("pomel");
		insert.setGeneratedKeyName("id");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("descricao", obj.getDescricao());
		param.addValue("material", obj.getMaterial());
		Number num = insert.executeAndReturnKey(param);
		obj.setId(num.longValue());
		return obj;
	}

	@Override
	public Pomel alterar(Pomel obj) throws Exception {
		String sql = "UPDATE POMEL SET DESCRICAO = ?, MATERIAL = ? WHERE ID = ?";
		int result = jdbc.update(sql, obj.getDescricao(), obj.getMaterial(), obj.getId());
		if(result > 0) {
			return obj;
		}
		return null;
	}

	@Override
	public boolean excluir(Pomel obj) throws Exception {
		String sql = "DELETE FROM POMEL WHERE ID = ?";
		int result = jdbc.update(sql, obj.getId());
		if(result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Pomel buscarPorCodigo(Long id) throws Exception {
		String sql = "SELECT * FROM POMEL WHERE ID = ?";
		return jdbc.queryForObject(sql, new PomelRowMapper(), id);
	}
	
	public List<Pomel> pesquisarDesc(String descricao) throws Exception{
		String sql = "SELECT * FROM POMEL WHERE UPPER(DESCRICAO) LIKE ?";
		descricao = "%" + descricao.toUpperCase().trim() + "%";
		return jdbc.query(sql, new PomelRowMapper(), descricao);
	}
}
