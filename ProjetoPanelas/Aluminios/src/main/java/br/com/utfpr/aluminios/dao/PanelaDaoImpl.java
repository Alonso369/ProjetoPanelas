package br.com.utfpr.aluminios.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.utfpr.aluminios.model.Panela;

@Repository
public class PanelaDaoImpl extends AbstractDaoImpl<Panela>{

	@Override
	public Panela inserir(Panela obj) throws Exception {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc);
		insert.setColumnNames(Arrays.asList("descricao", "idDisco", "idAlca", "idTampa", "preco"));
		insert.setTableName("panela");
		insert.setGeneratedKeyName("id");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("descricao", obj.getDescricao());
		param.addValue("idDisco", obj.getDisco().getId());
		param.addValue("idAlca", obj.getAlca().getId());
		param.addValue("idTampa", obj.getTampa().getId());
		param.addValue("preco", obj.getPreco());
		Number num = insert.executeAndReturnKey(param);
		obj.setId(num.longValue());
		return obj;		
	}

	@Override
	public Panela alterar(Panela obj) throws Exception {
		String sql = "UPDATE PANELA SET DESCRICAO = ?, IDDISCO = ?, IDALCA = ?, IDTAMPA = ?, PRECO = ? WHERE ID = ?";
		int result = jdbc.update(sql, obj.getDescricao(), obj.getDisco().getId(), obj.getAlca().getId(), obj.getTampa().getId(), obj.getPreco(), obj.getId());
		if(result > 0) {
			return obj;
		}
		return null;
	}

	@Override
	public boolean excluir(Panela obj) throws Exception {
		String sql = "DELETE FROM PANELA WHERE ID = ?";
		int result = jdbc.update(sql, obj.getId());
		if(result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Panela buscarPorCodigo(Long id) throws Exception {
		String sql = "SELECT * FROM PANELA WHERE ID = ?";
		return jdbc.queryForObject(sql, new PanelaRowMapper(), id);
	}
	
	public List<Panela> pesquisarDesc(String descricao) throws Exception{
		String sql = "SELECT * FROM PANELA "
				+ "JOIN DISCO ON PANELA.IDDISCO = DISCO.ID "
				+ "JOIN TAMPA ON PANELA.IDTAMPA = TAMPA.ID "
				+ "JOIN ALCA ON PANELA.IDALCA = ALCA.ID "
				+ "WHERE UPPER(PANELA.DESCRICAO) LIKE ?";
		descricao = "%" + descricao.toUpperCase().trim() + "%";
		return jdbc.query(sql, new PanelaRowMapper(true), descricao);
	} 
	
}
