package com.example.challengergrupoag.service;

import com.example.challengergrupoag.model.Atividade;
import com.example.challengergrupoag.model.Cliente;
import com.example.challengergrupoag.model.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AtividadeService {

    @Autowired
    private GerenciamentoService gerenciamentoService;

    public Atividade criarAtividade(Long clienteId, Long projetoId, String descricao, String status, String dataInicio, String dataFim) {

        // Buscando cliente e projeto
        Cliente cliente = gerenciamentoService.findClienteById(clienteId);
        Projeto projeto = gerenciamentoService.findProjetoById(projetoId);

        if (cliente == null || projeto == null) {
            throw new IllegalArgumentException("Cliente ou Projeto não encontrados!");
        }

        // Convertendo as datas para LocalDateTime
        LocalDateTime inicio = LocalDateTime.parse(dataInicio);
        LocalDateTime fim = LocalDateTime.parse(dataFim);

        // Criando a nova atividade
        Atividade novaAtividade = new Atividade(descricao, projeto,
                Atividade.StatusAtividade.valueOf(status),
                inicio, fim);
        novaAtividade.setCliente(cliente);

        // Salvando a atividade
        return gerenciamentoService.saveAtividade(novaAtividade);
    }

    public Atividade criarAtividade(Atividade atividade) {
        return gerenciamentoService.saveAtividade(atividade);
    }
}
