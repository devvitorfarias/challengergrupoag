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

    // Métodos de busca
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente findClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Atividade> findAtividadesByClienteId(Long clienteId) {
        return atividadeRepository.findByClienteId(clienteId);
    }

    public List<Projeto> findAllProjetos() {
        return projetoRepository.findAll();
    }

    public Projeto findProjetoById(Long id) {
        return projetoRepository.findById(id).orElse(null);
    }

    public List<Atividade> findAllAtividades() {
        List<Atividade> atividades = atividadeRepository.findAll();
        System.out.println("Atividades encontradas: " + atividades.size());
        return atividades;
    }


    public Atividade saveAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Projeto saveProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

}
