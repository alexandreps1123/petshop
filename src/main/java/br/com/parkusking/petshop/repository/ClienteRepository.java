package br.com.parkusking.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.parkusking.petshop.dto.ClienteDTO;
import br.com.parkusking.petshop.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
    
    @Query("SELECT new "
    + "br.com.parkusking.petshop.dto.ClienteDTO(c.nome, c.telefone) FROM Cliente c")
    public List<ClienteDTO> listarTodosDTO();

}