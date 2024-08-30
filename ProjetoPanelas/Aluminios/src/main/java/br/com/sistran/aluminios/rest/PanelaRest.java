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
import br.com.sistran.aluminios.model.Panela;
import br.com.sistran.aluminios.service.PanelaService;

@RestController
@RequestMapping("panela")
@CrossOrigin(value = "*")
public class PanelaRest {
	
	@Autowired
	PanelaService panelaService;
	
	@PostMapping
	public Panela inserir(@RequestBody Panela obj) throws Exception{
		return panelaService.inserir(obj);
	}
	
	@PutMapping
	public Panela alterar(@RequestBody Panela obj) throws Exception{
		return panelaService.alterar(obj);
	}
	
	@DeleteMapping(path = "/{id}")
	public boolean excluir(@PathVariable("id") Long id) throws Exception{
		Panela obj = new Panela();
		obj.setId(id);
		return panelaService.excluir(obj);
	}
	
	@GetMapping(path = "/{id}")
	public Panela buscarPorCodigo(@PathVariable("id") Long id) throws Exception{
		return panelaService.buscarPorCodigo(id);
	}
	
	@PostMapping(path = "pesquisarDesc")
	public List<Panela> pesquisarDesc(@RequestBody String descricao) throws Exception{
		return panelaService.pesquisarDesc(descricao);
	}
}
