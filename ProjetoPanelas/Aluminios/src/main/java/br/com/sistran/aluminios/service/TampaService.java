package br.com.sistran.aluminios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistran.aluminios.dao.AbstractDao;
import br.com.sistran.aluminios.dao.TampaDaoImpl;
import br.com.sistran.aluminios.model.Tampa;

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
