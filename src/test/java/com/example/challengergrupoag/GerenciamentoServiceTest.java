package com.example.challengergrupoag.service;

import com.example.challengergrupoag.model.Atividade;
import com.example.challengergrupoag.model.Cliente;
import com.example.challengergrupoag.model.Projeto;
import com.example.challengergrupoag.repository.AtividadeRepository;
import com.example.challengergrupoag.repository.ClienteRepository;
import com.example.challengergrupoag.repository.ProjetoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class GerenciamentoServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ProjetoRepository projetoRepository;

    @Mock
    private AtividadeRepository atividadeRepository;

    @InjectMocks
    private GerenciamentoService gerenciamentoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // ------------------ CLIENTES ------------------

    @Test
    void testFindAllClientes() {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Cliente 1");
        Cliente cliente2 = new Cliente();
        cliente2.setNome("Cliente 2");
        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);

        when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> result = gerenciamentoService.findAllClientes();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void testSaveCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Novo Cliente");

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = gerenciamentoService.saveCliente(cliente);

        assertNotNull(result);
        assertEquals("Novo Cliente", result.getNome());
        verify(clienteRepository, times(1)).save(cliente);
    }

    // ------------------ PROJETOS ------------------

    @Test
    void testFindAllProjetos() {
        Projeto projeto1 = new Projeto();
        projeto1.setNome("Projeto 1");
        Projeto projeto2 = new Projeto();
        projeto2.setNome("Projeto 2");
        List<Projeto> projetos = Arrays.asList(projeto1, projeto2);

        when(projetoRepository.findAll()).thenReturn(projetos);

        List<Projeto> result = gerenciamentoService.findAllProjetos();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(projetoRepository, times(1)).findAll();
    }

    @Test
    void testSaveProjeto() {
        Projeto projeto = new Projeto();
        projeto.setNome("Novo Projeto");

        when(projetoRepository.save(projeto)).thenReturn(projeto);

        Projeto result = gerenciamentoService.saveProjeto(projeto);

        assertNotNull(result);
        assertEquals("Novo Projeto", result.getNome());
        verify(projetoRepository, times(1)).save(projeto);
    }

    // ------------------ ATIVIDADES ------------------

    @Test
    void testFindAllAtividades() {
        Atividade atividade1 = new Atividade();
        atividade1.setDescricao("Atividade 1");
        Atividade atividade2 = new Atividade();
        atividade2.setDescricao("Atividade 2");
        List<Atividade> atividades = Arrays.asList(atividade1, atividade2);

        when(atividadeRepository.findAll()).thenReturn(atividades);

        List<Atividade> result = gerenciamentoService.findAllAtividades();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(atividadeRepository, times(1)).findAll();
    }

    @Test
    void testSaveAtividade() {
        Atividade atividade = new Atividade();
        atividade.setDescricao("Nova Atividade");

        when(atividadeRepository.save(atividade)).thenReturn(atividade);

        Atividade result = gerenciamentoService.saveAtividade(atividade);

        assertNotNull(result);
        assertEquals("Nova Atividade", result.getDescricao());
        verify(atividadeRepository, times(1)).save(atividade);
    }
}
