package com.example.challengergrupoag.repository;

import com.example.challengergrupoag.model.Atividade;
import com.example.challengergrupoag.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtividadeRepository  extends JpaRepository<Atividade, Long> {
    List<Atividade> findByProjeto(Projeto projeto);
}
