package com.example.jpa_h2_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jpa_h2_demo.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
