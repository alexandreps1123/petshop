package br.com.parkusking.petshop.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_ordem_servico")
    private Long codOrdemServico;

    @Column(name = "valor", nullable = false)
    private Double valor;
    
    @Column(name = "hora_entrada", columnDefinition = "date")
    private LocalDate horaEntrada;

    @Column(name = "hora_retirada", columnDefinition = "date")
    private LocalDate horaRetirada;

    @ManyToOne
    @JoinColumn(name="cod_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="cod_animal")
    private Animal animal;

    public OrdemServico() { }

    public Long getCodOrdemServico() {
        return codOrdemServico;
    }

    public void setCodOrdemServico(Long codOrdemServico) {
        this.codOrdemServico = codOrdemServico;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDate horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDate getHoraRetirada() {
        return horaRetirada;
    }

    public void setHoraRetirada(LocalDate horaRetirada) {
        this.horaRetirada = horaRetirada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
}

