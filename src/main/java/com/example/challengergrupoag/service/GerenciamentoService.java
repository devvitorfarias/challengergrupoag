package com.example.challengergrupoag.service;

import com.example.challengergrupoag.dto.AtividadeRelatorioDTO;
import com.example.challengergrupoag.dto.ProjetoRelatorioDto;
import com.example.challengergrupoag.model.Atividade;
import com.example.challengergrupoag.model.Cliente;
import com.example.challengergrupoag.model.Projeto;
import com.example.challengergrupoag.repository.AtividadeRepository;
import com.example.challengergrupoag.repository.ClienteRepository;
import com.example.challengergrupoag.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public Cliente findClienteById(Long clienteId){
        return clienteRepository.findById(clienteId).orElse(null);
    }

    // ------------------ PROJETOS ------------------

    public List<Projeto> findAllProjetos() {
        return projetoRepository.findAll();
    }

    public Projeto saveProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Projeto findProjetoById(Long projetoId){
        return projetoRepository.findById(projetoId).orElse(null);
    }
    public List<ProjetoRelatorioDto> obterRelatorioProjetosAtividades() {
        List<Projeto> projetos = projetoRepository.findAll();  // verifica se a consulta está correta

        List<ProjetoRelatorioDto> relatorioDTOs = new ArrayList<>();

        for (Projeto projeto : projetos) {
            ProjetoRelatorioDto projetoDTO = new ProjetoRelatorioDto();
            projetoDTO.setProjetoId(projeto.getId());
            projetoDTO.setProjetoNome(projeto.getNome());
            projetoDTO.setClienteNome(projeto.getCliente().getNome());

            // Buscando as atividades associadas ao projeto
            List<Atividade> atividades = atividadeRepository.findByProjeto(projeto);

            List<AtividadeRelatorioDTO> atividadesDTO = atividades.stream()
                    .map(atividade -> new AtividadeRelatorioDTO(
                            atividade.getId(),
                            atividade.getDescricao(),
                            atividade.getStatus(),
                            atividade.getDataInicio().toString(),
                            atividade.getDataFim().toString()))
                    .collect(Collectors.toList());

            projetoDTO.setAtividades(atividadesDTO);

            relatorioDTOs.add(projetoDTO);
        }

        return relatorioDTOs;
    }

    // ------------------ ATIVIDADES ------------------

    public List<Atividade> findAllAtividades() {
        return atividadeRepository.findAll();
    }

    public Atividade saveAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }
}
