package br.com.parkusking.petshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="animal")
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_animal")
    private Long codAnimal;
    
    @Column(name="nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name="idade")
    private Double idade;
    
    @Column(name="peso")
    private Double peso;
    
    @ManyToOne
    @JoinColumn(name="cod_cliente")
    private Cliente cliente;

    public Animal() { }

    public Long getCodAnimal() {
        return codAnimal;
    }

    public void setCodAnimal(Long codAnimal) {
        this.codAnimal = codAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getIdade() {
        return idade;
    }

    public void setIdade(Double idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

