package br.com.sistran.aluminios.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.sistran.aluminios.model.Disco;

@Repository
public class DiscoDaoImpl extends AbstractDaoImpl<Disco>{

	@Override
	public Disco inserir(Disco obj) throws Exception {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		insert.setColumnNames(Arrays.asList("descricao", "tamanho", "espessura"));
		insert.setTableName("disco");
		insert.setGeneratedKeyName("id");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("descricao", obj.getDescricao());
		param.addValue("tamanho", obj.getTamanho());
		param.addValue("espessura", obj.getEspessura());
		Number num = insert.executeAndReturnKey(param);
		obj.setId(num.longValue());
		return obj;
	}

	@Override
	public Disco alterar(Disco obj) throws Exception {
		String sql = "UPDATE DISCO SET DESCRICAO = ?, TAMANHO = ?, ESPESSURA = ? WHERE ID = ?";
		int result = jdbc.update(sql, obj.getDescricao(), obj.getTamanho(), obj.getEspessura(), obj.getId());
		if(result > 0) {
			return obj;
		}
		return null;
	}

	@Override
	public boolean excluir(Disco obj) throws Exception {
		String sql = "DELETE FROM DISCO WHERE ID = ?";
		int result = jdbc.update(sql, obj.getId());
		if(result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Disco buscarPorCodigo(Long id) throws Exception {
		String sql = "SELECT * FROM DISCO WHERE ID = ?";
		return jdbc.queryForObject(sql, new DiscoRowMapper(), id);
	}
	
	public List<Disco> pesquisarDesc(String descricao) throws Exception{
		String sql = "SELECT * FROM DISCO WHERE UPPER(descricao) LIKE ?";
		descricao = "%" + descricao.toUpperCase().trim() + "%";
		return jdbc.query(sql, new DiscoRowMapper(), descricao);
		
	}

}
