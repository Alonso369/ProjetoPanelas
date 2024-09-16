package br.com.utfpr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.utfpr.aluminios.dao.AbstractDao;
import br.com.utfpr.aluminios.dao.TampaDaoImpl;
import br.com.utfpr.aluminios.model.Tampa;

@Service
public class TampaService extends AbstractService<Tampa>{

	@Autowired
	private TampaDaoImpl dao;
	
	@Override
	public AbstractDao<Tampa> getDao() {
		return dao;
	}
	
	public List<Tampa> pesquisarDesc(String descricao) throws Exception{
		return dao.pesquisarDesc(descricao);
	}

}
