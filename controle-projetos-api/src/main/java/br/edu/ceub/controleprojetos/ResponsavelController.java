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

@Tag(name = "Responsáveis", description = "Gerencia os responsáveis pelos projetos")
@RestController
@RequestMapping("/api/responsaveis")
public class ResponsavelController {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @GetMapping
    public List<Responsavel> listarResponsaveis() {
        return responsavelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Responsavel buscarPorId(@PathVariable Long id) {
        Optional<Responsavel> responsavel = responsavelRepository.findById(id);
        if (responsavel.isPresent()) {
            return responsavel.get();
        }
        return null;
    }

    @PostMapping
    public Responsavel salvarResponsavel(@RequestBody Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    @PutMapping("/{id}")
    public Responsavel atualizarResponsavel(@PathVariable Long id, @RequestBody Responsavel responsavel) {
        Optional<Responsavel> oResponsavel = responsavelRepository.findById(id);
        if (oResponsavel.isPresent()) {
            Responsavel existente = oResponsavel.get();
            existente.setNome(responsavel.getNome());
            existente.setEmail(responsavel.getEmail());
            existente.setTelefone(responsavel.getTelefone());
            return responsavelRepository.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarResponsavel(@PathVariable Long id) {
        responsavelRepository.deleteById(id);
    }
}
