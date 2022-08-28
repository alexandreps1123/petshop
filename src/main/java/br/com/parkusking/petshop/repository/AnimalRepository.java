package br.com.parkusking.petshop.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.parkusking.petshop.model.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Long>{
    
}
