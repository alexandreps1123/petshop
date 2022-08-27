package br.com.parkusking.petshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codCliente;

    private String nome;
    
    private String telefone;

    public Cliente() {
    }

    public Cliente(Long codCliente) {
        this.codCliente = codCliente;
    }

    public Cliente(Long codCliente, String nome, String telefone) {
        this.codCliente = codCliente;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Long codCliente) {
        this.codCliente = codCliente;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

