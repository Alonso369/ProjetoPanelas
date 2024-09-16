package br.com.utfpr.service;

import br.com.utfpr.aluminios.dao.AbstractDao;
import br.com.utfpr.aluminios.model.BaseEntity;

public abstract class AbstractService <T extends BaseEntity>{
	
	public abstract AbstractDao<T> getDao();
	
	public T salvar(T obj) throws Exception{
		if(obj.getId() == null) {
			return inserir(obj);
		} else {
			return alterar(obj);
		}
	}
	
	public T inserir(T obj) throws Exception{
		return getDao().inserir(obj);
	}
	
	public T alterar(T obj) throws Exception{
		return getDao().alterar(obj);
	}
	
	public boolean excluir(T obj) throws Exception{
		return getDao().excluir(obj);
	}
	
	public T buscarPorCodigo(Long id) throws Exception{
		return getDao().buscarPorCodigo(id);
	}
}