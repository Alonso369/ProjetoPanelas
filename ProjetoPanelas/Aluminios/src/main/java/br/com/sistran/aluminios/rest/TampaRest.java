package br.com.sistran.aluminios.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistran.aluminios.model.Tampa;
import br.com.sistran.aluminios.service.TampaService;

@RestController
@RequestMapping("tampa")
@CrossOrigin(value = "*")
public class TampaRest {
	
	@Autowired
	TampaService tampaService;
	
	
	@PostMapping
	public Tampa inserir(@RequestBody Tampa obj) throws Exception{
		return tampaService.inserir(obj);
	}
	
	@PutMapping
	public Tampa alterar(@RequestBody Tampa obj) throws Exception{
		return tampaService.alterar(obj);
	}
	
	@DeleteMapping(path = "/{id}")
	public boolean excluir(@PathVariable("id") Long id) throws Exception{
		Tampa obj = new Tampa();
		obj.setId(id);
		return tampaService.excluir(obj);
	}
	
	@GetMapping(path = "/{id}")
	public Tampa buscarPorCodigo(@PathVariable("id") Long id) throws Exception{
		return tampaService.buscarPorCodigo(id);
	}
	
	@PostMapping(path = "pesquisarDesc")
	public List<Tampa> pesquisarDesc(@RequestBody String descricao) throws Exception{
		return tampaService.pesquisarDesc(descricao);
	}
	
}
