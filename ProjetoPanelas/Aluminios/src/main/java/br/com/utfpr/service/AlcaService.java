package br.com.utfpr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.utfpr.aluminios.dao.AbstractDao;
import br.com.utfpr.aluminios.dao.AlcaDaoImpl;
import br.com.utfpr.aluminios.model.Alca;

@Service
public class AlcaService extends AbstractService<Alca>{

	@Autowired(required = false)
	private AlcaDaoImpl dao;
	
	@Override
	public AbstractDao<Alca> getDao() {
		return dao;
	}
	
	public List<Alca> pesquisarDesc(String descricao) throws Exception{
		return dao.pesquisarDesc(descricao);		
	}
	
}
