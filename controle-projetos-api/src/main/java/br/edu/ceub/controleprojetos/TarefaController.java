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

@Tag(name = "Tarefas", description = "Gerencia as tarefas vinculadas aos projetos")
@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if (tarefa.isPresent()) {
            return tarefa.get();
        }
        return null;
    }

    @PostMapping
    public Tarefa salvarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        Optional<Tarefa> oTarefa = tarefaRepository.findById(id);
        if (oTarefa.isPresent()) {
            Tarefa existente = oTarefa.get();
            existente.setTitulo(tarefa.getTitulo());
            existente.setDescricao(tarefa.getDescricao());
            existente.setStatus(tarefa.getStatus());
            existente.setProjeto(tarefa.getProjeto());
            return tarefaRepository.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaRepository.deleteById(id);
    }
}
