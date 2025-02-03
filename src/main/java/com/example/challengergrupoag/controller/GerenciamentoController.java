package com.example.challengergrupoag.controller;

import com.example.challengergrupoag.dto.AtividadeRelatorioDTO;
import com.example.challengergrupoag.model.Atividade;
import com.example.challengergrupoag.model.Cliente;
import com.example.challengergrupoag.model.Projeto;
import com.example.challengergrupoag.service.GerenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @PutMapping("/atividades/{id}")
    public ResponseEntity<Atividade> atualizarAtividade(
            @PathVariable Long id,
            @RequestBody AtividadeRelatorioDTO atividadeDTO) {

        // Verifica se a atividade existe
        Optional<Atividade> atividadeOptional = gerenciamentoService.findAtividadeById(id);
        if (!atividadeOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Atividade atividade = atividadeOptional.get();

        // Atualiza os campos da atividade com os dados do DTO
        atividade.setDescricao(atividadeDTO.getDescricao());
        atividade.setStatus(atividadeDTO.getStatus());

        // Converte as datas de String para LocalDateTime (se necessário)
        atividade.setDataInicio(LocalDateTime.parse(atividadeDTO.getDataInicio()));
        atividade.setDataFim(LocalDateTime.parse(atividadeDTO.getDataFim()));

        // Salva a atividade atualizada
        Atividade atividadeAtualizada = gerenciamentoService.saveAtividade(atividade);
        return ResponseEntity.ok(atividadeAtualizada);
    }
}
