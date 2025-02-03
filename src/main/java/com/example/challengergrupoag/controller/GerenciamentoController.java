package com.example.challengergrupoag.controller;

import com.example.challengergrupoag.model.Atividade;
import com.example.challengergrupoag.model.Cliente;
import com.example.challengergrupoag.model.Projeto;
import com.example.challengergrupoag.service.AtividadeService;
import com.example.challengergrupoag.service.GerenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerenciamento")
public class GerenciamentoController {

    @Autowired
    private GerenciamentoService gerenciamentoService;

    @Autowired
    private AtividadeService atividadeService;

    // ------------------ CLIENTES ------------------

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return ResponseEntity.ok(gerenciamentoService.findAllClientes());
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(gerenciamentoService.saveCliente(cliente));
    }

    // Endpoint para buscar atividades de um cliente específico:
    @GetMapping("/clientes/{clienteId}/atividades")
    public ResponseEntity<List<Atividade>> getAtividadesPorCliente(@PathVariable Long clienteId) {
        List<Atividade> atividades = gerenciamentoService.findAtividadesByClienteId(clienteId);
        if (atividades.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atividades);
    }

    // ------------------ PROJETOS ------------------

    @GetMapping("/projetos")
    public ResponseEntity<List<Projeto>> getAllProjetos() {
        return ResponseEntity.ok(gerenciamentoService.findAllProjetos());
    }

    @PostMapping("/projetos")
    public ResponseEntity<Projeto> createProjeto(@RequestBody Projeto projeto) {
        return ResponseEntity.ok(gerenciamentoService.saveProjeto(projeto));
    }

    // ------------------ ATIVIDADES ------------------

    @GetMapping("/atividades")
    public ResponseEntity<List<Atividade>> getAllAtividades() {
        return ResponseEntity.ok(gerenciamentoService.findAllAtividades());
    }

    @PostMapping("/atividades")
    public ResponseEntity<Atividade> createAtividade(@RequestBody Atividade atividade) {
        Atividade novaAtividade = atividadeService.criarAtividade(atividade);
        return ResponseEntity.ok(novaAtividade);
    }

    // Endpoint para adicionar uma nova atividade
    @PostMapping("/adicionar")
    public ResponseEntity<Atividade> adicionarAtividade(
            @RequestParam Long clienteId,
            @RequestParam Long projetoId,
            @RequestParam String descricao,
            @RequestParam String status,
            @RequestParam String dataInicio,
            @RequestParam String dataFim) {

        Atividade novaAtividade = atividadeService.criarAtividade(clienteId, projetoId, descricao, status, dataInicio, dataFim);
        return ResponseEntity.ok(novaAtividade);
    }
}
