package com.example.challengergrupoag.controller;

import com.example.challengergrupoag.model.Atividade;
import com.example.challengergrupoag.model.Cliente;
import com.example.challengergrupoag.model.Projeto;
import com.example.challengergrupoag.service.AtividadeService;
import com.example.challengergrupoag.service.GerenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
        List<Cliente> clientes = gerenciamentoService.findAllClientes();
        return ResponseEntity.ok()
                .header("Cache-Control", "no-store, no-cache, must-revalidate, proxy-revalidate")
                .body(clientes); // Impede cache no cliente
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        // Evita cache para operações de criação
        Cliente novoCliente = gerenciamentoService.saveCliente(cliente);
        return ResponseEntity.ok()
                .header("Cache-Control", "no-cache, no-store, must-revalidate")
                .body(novoCliente);
    }

    // ------------------ ATIVIDADES ------------------

    @GetMapping("/atividades")
    public ResponseEntity<List<Atividade>> getAllAtividades() {
        List<Atividade> atividades = gerenciamentoService.findAllAtividades();
        return ResponseEntity.ok()
                .header("Cache-Control", "no-store, no-cache, must-revalidate, proxy-revalidate")
                .body(atividades); // Impede cache no cliente
    }

    // Endpoint para criar uma nova atividade associada a um cliente e projeto
    @PostMapping("/atividades")
    public ResponseEntity<Atividade> createAtividade(@RequestBody Atividade atividade) {
        Cliente cliente = gerenciamentoService.findClienteById(atividade.getCliente().getId());
        Projeto projeto = gerenciamentoService.findProjetoById(atividade.getProjeto().getId());

        if (cliente == null || projeto == null) {
            return ResponseEntity.badRequest().body(null); // Retorna 400 caso cliente ou projeto não existam
        }

        atividade.setCliente(cliente);
        atividade.setProjeto(projeto);

        Atividade novaAtividade = atividadeService.criarAtividade(atividade); // Cria a atividade no serviço
        return ResponseEntity.ok()
                .header("Cache-Control", "no-cache, no-store, must-revalidate")
                .body(novaAtividade); // Impede cache para criação de atividade
    }

    // Endpoint para atualizar parcialmente uma atividade
    @PatchMapping("/atividades/{atividadeId}")
    public ResponseEntity<Atividade> atualizarAtividade(
            @PathVariable Long atividadeId,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String dataInicio,
            @RequestParam(required = false) String dataFim) {

        // Encontra a atividade existente
        Atividade atividadeExistente = atividadeService.findById(atividadeId);

        if (atividadeExistente == null) {
            return ResponseEntity.notFound().build();  // Retorna 404 caso a atividade não exista
        }

        // Atualiza os campos fornecidos (se existirem)
        if (descricao != null) {
            atividadeExistente.setDescricao(descricao);
        }
        if (status != null) {
            atividadeExistente.setStatus(Atividade.StatusAtividade.valueOf(status));
        }
        if (dataInicio != null) {
            atividadeExistente.setDataInicio(LocalDateTime.parse(dataInicio));
        }
        if (dataFim != null) {
            atividadeExistente.setDataFim(LocalDateTime.parse(dataFim));
        }

        // Atualiza a atividade no banco de dados
        Atividade atividadeAtualizada = atividadeService.atualizarAtividade(atividadeExistente);

        return ResponseEntity.ok()
                .header("Cache-Control", "no-cache, no-store, must-revalidate")
                .body(atividadeAtualizada); // Impede cache para a atualização de atividade
    }

    // ------------------ PROJETOS ------------------

    @GetMapping("/projetos")
    public ResponseEntity<List<Projeto>> getAllProjetos() {
        List<Projeto> projetos = gerenciamentoService.findAllProjetos();
        return ResponseEntity.ok()
                .header("Cache-Control", "no-store, no-cache, must-revalidate, proxy-revalidate")
                .body(projetos); // Impede cache no cliente
    }

    @PostMapping("/projetos")
    public ResponseEntity<Projeto> createProjeto(@RequestBody Projeto projeto) {
        Projeto novoProjeto = gerenciamentoService.saveProjeto(projeto);
        return ResponseEntity.ok()
                .header("Cache-Control", "no-cache, no-store, must-revalidate")
                .body(novoProjeto); // Impede cache para a criação de projetos
    }

    // Endpoint para adicionar uma nova atividade (parâmetros via request params)
    @PostMapping("/adicionar")
    public ResponseEntity<Atividade> adicionarAtividade(
            @RequestParam Long clienteId,
            @RequestParam Long projetoId,
            @RequestParam String descricao,
            @RequestParam String status,
            @RequestParam String dataInicio,
            @RequestParam String dataFim) {

        // Verifica se o cliente e o projeto existem
        Cliente cliente = gerenciamentoService.findClienteById(clienteId);
        Projeto projeto = gerenciamentoService.findProjetoById(projetoId);

        if (cliente == null || projeto == null) {
            return ResponseEntity.badRequest().body(null); // Retorna 400 caso cliente ou projeto não existam
        }

        // Cria a atividade associada ao cliente e projeto
        Atividade novaAtividade = atividadeService.criarAtividade(clienteId, projetoId, descricao, status, dataInicio, dataFim);
        novaAtividade.setCliente(cliente);
        novaAtividade.setProjeto(projeto);

        return ResponseEntity.ok()
                .header("Cache-Control", "no-cache, no-store, must-revalidate")
                .body(novaAtividade); // Impede cache para a criação de nova atividade
    }
}
