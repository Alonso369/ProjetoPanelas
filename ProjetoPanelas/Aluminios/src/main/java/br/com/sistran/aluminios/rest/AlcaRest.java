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

import br.com.sistran.aluminios.model.Alca;
import br.com.sistran.aluminios.service.AlcaService;

@RestController
@RequestMapping("alca")
@CrossOrigin(value = "*")
public class AlcaRest {
	
	@Autowired
	AlcaService alcaService;
	
	@PostMapping
	public Alca inserir(@RequestBody Alca alca) throws Exception{
		return alcaService.inserir(alca);
	}
	
	@PutMapping
	public Alca alterar(@RequestBody Alca alca) throws Exception{
		return alcaService.alterar(alca);
	}
	
	@DeleteMapping(path = "/{id}")
	public boolean excluir(@PathVariable("id") Long id) throws Exception{
		Alca alca = new Alca();
		alca.setId(id);
		return alcaService.excluir(alca);
	}
	
	@GetMapping(path = "/{id}")
	public Alca buscarPorCodigo(@PathVariable("id") Long id) throws Exception{
		return alcaService.buscarPorCodigo(id);
	}
	
	@PostMapping(path = "pesquisarDesc")
	public List<Alca> pesquisarDesc(@RequestBody String descricao) throws Exception{
		return alcaService.pesquisarDesc(descricao);
		
	}
}
