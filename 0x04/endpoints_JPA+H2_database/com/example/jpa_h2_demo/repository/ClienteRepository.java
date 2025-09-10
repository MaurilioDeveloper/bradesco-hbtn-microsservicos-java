package com.example.jpa_h2_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jpa_h2_demo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
