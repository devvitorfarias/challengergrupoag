package com.example.challengergrupoag.service;

import com.example.challengergrupoag.model.Atividade;
import com.example.challengergrupoag.model.Cliente;
import com.example.challengergrupoag.model.Projeto;
import com.example.challengergrupoag.repository.AtividadeRepository;
import com.example.challengergrupoag.repository.ClienteRepository;
import com.example.challengergrupoag.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenciamentoService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    // ------------------ CLIENTES ------------------

    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // ------------------ PROJETOS ------------------

    public List<Projeto> findAllProjetos() {
        return projetoRepository.findAll();
    }

    public Projeto saveProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    // ------------------ ATIVIDADES ------------------

    public List<Atividade> findAllAtividades() {
        return atividadeRepository.findAll();
    }

    public Atividade saveAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }
}
