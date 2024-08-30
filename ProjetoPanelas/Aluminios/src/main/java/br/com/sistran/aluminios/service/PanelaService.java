package br.com.sistran.aluminios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistran.aluminios.dao.AbstractDao;
import br.com.sistran.aluminios.dao.PanelaDaoImpl;
import br.com.sistran.aluminios.model.Panela;

@Service
public class PanelaService extends AbstractService<Panela>{

	@Autowired
	private PanelaDaoImpl dao;
	
	@Override
	public AbstractDao<Panela> getDao() {
		return dao;
	}
	
	public List<Panela> pesquisarDesc(String descricao) throws Exception{
		return dao.pesquisarDesc(descricao);
	} 

}
