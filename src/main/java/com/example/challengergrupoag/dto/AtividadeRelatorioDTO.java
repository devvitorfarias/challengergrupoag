package com.example.challengergrupoag.dto;

public class AtividadeRelatorioDTO {

    private Long atividadeId;
    private String descricao;
    private String status; // Pode ser "Em andamento", "Concluída".
    private String dataInicio;
    private String dataFim;

    // Construtor vazio
    public AtividadeRelatorioDTO() {}

    // Construtor com parâmetros
    public AtividadeRelatorioDTO(Long atividadeId, String descricao, String status, String dataInicio, String dataFim) {
        this.atividadeId = atividadeId;
        this.descricao = descricao;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters e Setters
    public Long getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Long atividadeId) {
        this.atividadeId = atividadeId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
}
