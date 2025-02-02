package com.example.challengergrupoag.dto;

import java.util.List;

public class ProjetoRelatorioDto {

    private Long projetoId;
    private String projetoNome;
    private String clienteNome;
    private List<AtividadeRelatorioDTO> atividades;

    // Construtores
    public ProjetoRelatorioDto() {}

    public ProjetoRelatorioDto(Long projetoId, String projetoNome, String clienteNome, List<AtividadeRelatorioDTO> atividades) {
        this.projetoId = projetoId;
        this.projetoNome = projetoNome;
        this.clienteNome = clienteNome;
        this.atividades = atividades;
    }

    // Getters e Setters
    public Long getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(Long projetoId) {
        this.projetoId = projetoId;
    }

    public String getProjetoNome() {
        return projetoNome;
    }

    public void setProjetoNome(String projetoNome) {
        this.projetoNome = projetoNome;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public List<AtividadeRelatorioDTO> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<AtividadeRelatorioDTO> atividades) {
        this.atividades = atividades;
    }
}
