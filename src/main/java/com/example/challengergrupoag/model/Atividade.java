package com.example.challengergrupoag.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    private String status;  // Status da atividade (Ex: "Em andamento", "Concluída")
    private LocalDateTime dataInicio;  // Data de início da atividade
    private LocalDateTime dataFim;  // Data de fim da atividade

    // Construtor vazio (necessário para JPA)
    public Atividade() {}

    public Atividade(String descricao, Projeto projeto, String status, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.descricao = descricao;
        this.projeto = projeto;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }
}
