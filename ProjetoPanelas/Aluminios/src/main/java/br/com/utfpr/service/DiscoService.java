package br.com.utfpr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.utfpr.aluminios.dao.AbstractDao;
import br.com.utfpr.aluminios.dao.DiscoDaoImpl;
import br.com.utfpr.aluminios.model.Disco;


@Service
public class DiscoService extends AbstractService<Disco>{

	@Autowired(required = false)
	private DiscoDaoImpl dao;
	
	@Override
	public AbstractDao<Disco> getDao() {
		return dao;
	}
	
	public List<Disco> pesquisarDesc(String descricao) throws Exception{
		return dao.pesquisarDesc(descricao);		
	}
	
}
