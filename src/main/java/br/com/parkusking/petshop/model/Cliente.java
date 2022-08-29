package br.com.parkusking.petshop.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;

@Entity                                             // indica que a classe eh armazenavel no banco
@Table(name = "cliente")                            // explicita o nome da tabela no banco
public class Cliente {
    @Id                                             // Indica que o atributo eh PK da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // representa o auto-incremnte no MySQL
    @Column(name = "cod_cliente")                   // nome da coluna na tabela
    private Long codCliente;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "telefone", length = 20, nullable = true)
    private String telefone;

    public Cliente() { }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
