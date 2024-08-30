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

import br.com.sistran.aluminios.model.Pomel;
import br.com.sistran.aluminios.service.PomelService;

@RestController
@RequestMapping("pomel")
@CrossOrigin(value = "*")
public class PomelRest {

	@Autowired
	PomelService pomelService;
	
	@PostMapping
	public Pomel inserir(@RequestBody Pomel obj) throws Exception {
		return pomelService.inserir(obj);
	}

	@PutMapping
	public Pomel alterar(@RequestBody Pomel obj) throws Exception {
		return pomelService.alterar(obj);
	}

	@DeleteMapping(path = "/{id}")
	public boolean excluir(@PathVariable("id")Long id) throws Exception {
		Pomel pomel = new Pomel();
		pomel.setId(id);
		return pomelService.excluir(pomel);
	}

	@GetMapping(path = "/{id}")
	public Pomel buscarPorCodigo(@PathVariable("id")Long id) throws Exception {
		return pomelService.buscarPorCodigo(id);
	}
	
	@PostMapping(path = "pesquisarDesc")
	public List<Pomel> pesquisarDesc(@RequestBody String descricao) throws Exception{
		return pomelService.pesquisarDesc(descricao);
	}
}
