package br.com.utfpr.aluminios.dao;

import br.com.utfpr.aluminios.model.BaseEntity;

public interface AbstractDao <T extends BaseEntity>{
	
	public T inserir(T obj) throws Exception;
	
	public T alterar(T obj) throws Exception;
	
	public boolean excluir(T obj) throws Exception;
	
	public T buscarPorCodigo(Long id) throws Exception;
	
}

