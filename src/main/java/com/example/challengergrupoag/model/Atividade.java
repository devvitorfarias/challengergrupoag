package com.example.challengergrupoag.model;


import jakarta.persistence.*;

@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    // Construtor vazio (necessário para JPA)
    public Atividade() {}

    public Atividade(String descricao, Projeto projeto) {
        this.descricao = descricao;
        this.projeto = projeto;
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

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
