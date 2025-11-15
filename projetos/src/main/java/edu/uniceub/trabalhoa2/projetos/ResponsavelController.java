package edu.uniceub.trabalhoa2.projetos;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/pessoa")
public class ResponsavelController {

	@AutoMapping
	ResponsavelRepository responsavelRepository;
	
	@GetMapping
	public List<Responsavel> listarRepository(){
		return responsavelRepository.findAll();
	}
	
	@PostMapping
	public Responsavel salvarResponsavel(@RequestBody Responsavel responsavel) {
		return responsavelRepository.save(responsavel);
	}
	
	@PutMapping("/{id}")
	public void deletarResponsavel(@PathVariable Long id,
									@RequestBody Responsavel responsavel) {
		
		Optional<Responsavel> oResponsavel = responsavelRepository.findById(id);
		if(oResponsavel.isPresent()) {
			Responsavel r = oResponsavel.get();
			r.setEmail(responsavel.getEmail());
			r.setId(responsavel.getId());
			r.setNome(responsavel.getNome());
			r.setTelefone(responsavel.getTelefone());
			return responsavelRepository.save(r);
			}
		return null;

	}
	

}
