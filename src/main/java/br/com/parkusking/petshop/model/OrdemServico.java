package br.com.parkusking.petshop.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codOrdemServico;

    private Double valor;
    private String horaEntrada;
    private String horaRetirada;

    @ManyToOne(fetch = FetchType.EAGER,  cascade={ })
    @JoinColumn(name="codCliente")
    private Cliente cliente;
    
    public OrdemServico() {
    }

    public OrdemServico(Cliente cliente, Double valor, String horaEntrada, String horaRetirada) {
        this.cliente = cliente;
        this.valor = valor;
        this.horaEntrada = horaEntrada;
        this.horaRetirada = horaRetirada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraRetirada() {
        return horaRetirada;
    }

    public void setHoraRetirada(String horaRetirada) {
        this.horaRetirada = horaRetirada;
    }
}

