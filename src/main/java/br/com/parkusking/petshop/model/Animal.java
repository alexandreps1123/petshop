package br.com.parkusking.petshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="animal")
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cod_animal")
    private Long codAnimal;
    
    @Column(name="nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name="idade")
    private Integer idade;
    
    @Column(name="peso")
    private Double peso;

    // 
    @ManyToOne(fetch = FetchType.EAGER,  cascade={ })
    @JoinColumn(name="codCliente")
    private Cliente cliente;

    public Animal() {
    }

    public Animal(String nome, Integer idade, Double peso, Cliente cliente) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.cliente = cliente;
    }

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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
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

