package br.com.parkusking.petshop.dto;

public class ClienteDTO {

    private String nome;
    private String telefone;

    public ClienteDTO() { }

    public ClienteDTO(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
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
