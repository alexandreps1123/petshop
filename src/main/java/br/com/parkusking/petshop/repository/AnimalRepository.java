package br.com.parkusking.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.parkusking.petshop.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
    
}
