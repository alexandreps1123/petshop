package br.com.parkusking.petshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_ordem_servico")
    private Long codOrdemServico;

    @Column(name = "valor", nullable = false)
    private Double valor;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "hora_entrada")
    private String horaEntrada;

    @Temporal(TemporalType.DATE)
    @Column(name = "hora_retirada")
    private String horaRetirada;


    // 
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

