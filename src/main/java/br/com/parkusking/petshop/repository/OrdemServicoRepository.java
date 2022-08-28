package br.com.parkusking.petshop.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.parkusking.petshop.model.OrdemServico;

public interface OrdemServicoRepository extends CrudRepository<OrdemServico, Long>{
    
}