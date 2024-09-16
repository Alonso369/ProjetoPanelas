package br.com.utfpr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.utfpr.aluminios.dao.AbstractDao;
import br.com.utfpr.aluminios.dao.PomelDaoImpl;
import br.com.utfpr.aluminios.model.Pomel;

@Service
public class PomelService extends AbstractService<Pomel>{
	
	@Autowired
	private PomelDaoImpl dao;
	
	@Override
	public AbstractDao<Pomel> getDao() {
		return dao;
	}
	
	public List<Pomel> pesquisarDesc(String descricao) throws Exception{
		return dao.pesquisarDesc(descricao);
	}
}
