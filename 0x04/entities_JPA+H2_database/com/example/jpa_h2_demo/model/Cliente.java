package com.example.jpa_h2_demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Um cliente possui vários telefones
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones = new ArrayList<>();

    // Um cliente possui vários endereços
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente() {}

    public Cliente(String nome) {
        this.nome = nome;
    }

    // helpers para manter relação bidirecional
    public void addTelefone(Telefone t) {
        if (t == null) return;
        telefones.add(t);
        t.setCliente(this);
    }
    public void removeTelefone(Telefone t) {
        if (t == null) return;
        telefones.remove(t);
        t.setCliente(null);
    }
    public void addEndereco(Endereco e) {
        if (e == null) return;
        enderecos.add(e);
        e.setCliente(this);
    }
    public void removeEndereco(Endereco e) {
        if (e == null) return;
        enderecos.remove(e);
        e.setCliente(null);
    }

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Telefone> getTelefones() { return telefones; }
    public void setTelefones(List<Telefone> telefones) { this.telefones = telefones; }

    public List<Endereco> getEnderecos() { return enderecos; }
    public void setEnderecos(List<Endereco> enderecos) { this.enderecos = enderecos; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
