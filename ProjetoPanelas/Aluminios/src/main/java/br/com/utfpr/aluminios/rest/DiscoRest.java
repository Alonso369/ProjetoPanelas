package br.com.utfpr.aluminios.rest;

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

import br.com.utfpr.aluminios.model.Disco;
import br.com.utfpr.service.DiscoService;

@RestController
@RequestMapping("disco")
@CrossOrigin(value= "*")
public class DiscoRest {
	@Autowired
	private DiscoService discoService;
	
	@PostMapping
	public Disco inserir(@RequestBody Disco disco) throws Exception{
		return discoService.inserir(disco);
	}
	
	@PutMapping
	public Disco alterar(@RequestBody Disco disco) throws Exception{
		return discoService.alterar(disco);
	}
	
	@DeleteMapping(path = "/{id}")
	public boolean excluir(@PathVariable("id") Long id) throws Exception{
		Disco disco = new Disco();
		disco.setId(id);
		return discoService.excluir(disco);
	}
	
	@GetMapping(path = "/{id}")
	public Disco buscarPorCodigo(@PathVariable("id") Long id) throws Exception{
		return discoService.buscarPorCodigo(id);
	}
	
	@PostMapping(path = "pesquisarDesc")
	public List<Disco> pesquisarDesc(@RequestBody String descricao) throws Exception{
		return discoService.pesquisarDesc(descricao);
		
	}
}
