package br.com.parkusking.petshop.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.parkusking.petshop.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
    
}