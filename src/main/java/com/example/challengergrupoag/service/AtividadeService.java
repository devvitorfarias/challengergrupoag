package com.example.challengergrupoag.service;

import com.example.challengergrupoag.model.Atividade;
import com.example.challengergrupoag.model.Cliente;
import com.example.challengergrupoag.model.Projeto;
import com.example.challengergrupoag.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AtividadeService {

    @Autowired
    private GerenciamentoService gerenciamentoService;

    @Autowired
    private AtividadeRepository atividadeRepository;  // Injeção do repositório

    // Método para criar atividade a partir de IDs de cliente e projeto
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
        return atividadeRepository.save(novaAtividade);  // Usando o save do repositório
    }

    // Método para criar uma atividade diretamente a partir do objeto
    public Atividade criarAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);  // Usando o save do repositório
    }

    // Método para buscar atividade pelo ID
    public Atividade findById(Long atividadeId) {
        return atividadeRepository.findById(atividadeId)
                .orElse(null);  // Retorna null se a atividade não for encontrada
    }

    // Método para atualizar a atividade
    public Atividade atualizarAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);  // Atualiza ou salva a atividade no banco
    }
}
