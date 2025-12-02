package br.edu.ceub.controleprojetos;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Projetos", description = "Gerencia os projetos do sistema")
@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;

    @GetMapping
    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Projeto buscarPorId(@PathVariable Long id) {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if (projeto.isPresent()) {
            return projeto.get();
        }
        return null;
    }

    @PostMapping
    public Projeto salvarProjeto(@RequestBody Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @PutMapping("/{id}")
    public Projeto atualizarProjeto(@PathVariable Long id, @RequestBody Projeto projeto) {
        Optional<Projeto> oProjeto = projetoRepository.findById(id);
        if (oProjeto.isPresent()) {
            Projeto existente = oProjeto.get();
            existente.setNome(projeto.getNome());
            existente.setDescricao(projeto.getDescricao());
            existente.setResponsavel(projeto.getResponsavel());
            return projetoRepository.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarProjeto(@PathVariable Long id) {
        projetoRepository.deleteById(id);
    }
}
