package br.com.utfpr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.utfpr.aluminios.dao.AbstractDao;
import br.com.utfpr.aluminios.dao.PanelaDaoImpl;
import br.com.utfpr.aluminios.model.Panela;

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
