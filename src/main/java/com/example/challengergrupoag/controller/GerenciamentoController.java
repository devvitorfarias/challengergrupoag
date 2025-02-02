package com.example.challengergrupoag.controller;

import com.example.challengergrupoag.model.Atividade;
import com.example.challengergrupoag.model.Cliente;
import com.example.challengergrupoag.model.Projeto;
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

    // ------------------ CLIENTES ------------------

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return ResponseEntity.ok(gerenciamentoService.findAllClientes());
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(gerenciamentoService.saveCliente(cliente));
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
        return ResponseEntity.ok(gerenciamentoService.saveAtividade(atividade));
    }

    @PostMapping("/atribuir-atividade")
    public ResponseEntity<Atividade> atribuirAtividade(@RequestParam Long clienteId, @RequestParam Long projetoId, @RequestBody Atividade atividade) {
        Cliente cliente = gerenciamentoService.findClienteById(clienteId);
        Projeto projeto = gerenciamentoService.findProjetoById(projetoId);

        if (cliente == null || projeto == null) {
            return ResponseEntity.notFound().build();
        }

        atividade.setCliente(cliente);
        atividade.setProjeto(projeto);

        Atividade atividadeSalva = gerenciamentoService.saveAtividade(atividade);

        return ResponseEntity.ok(atividadeSalva);
    }
}
