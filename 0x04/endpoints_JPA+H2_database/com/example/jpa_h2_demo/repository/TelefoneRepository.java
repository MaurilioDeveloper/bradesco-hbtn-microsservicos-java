package com.example.jpa_h2_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jpa_h2_demo.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
