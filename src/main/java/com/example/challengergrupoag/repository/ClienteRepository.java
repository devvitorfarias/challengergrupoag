package com.example.challengergrupoag.repository;

import com.example.challengergrupoag.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
}
