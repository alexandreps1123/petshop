package br.com.parkusking.petshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.parkusking.petshop.model.Animal;
import br.com.parkusking.petshop.repository.AnimalRepository;

@Service
public class AnimalService {

    private final AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public List<Animal> listarTodos() {
        return (List<Animal>)repository.findAll();
    }
    
    public Animal listarPorId(Long codAnimal) {
        return repository.findById(codAnimal).orElse(null);
    }

    public boolean existeId(Long codAnimal) {
        return repository.existsById(codAnimal);
    }

    @Transactional
    public Animal salvar(Animal animal) {
        return repository.save(animal);
    }

    @Transactional
    public Animal alterar(Animal animal){
        return repository.save(animal);
    }

    @Transactional
	public void remover(Long codAnimal){
        repository.deleteById(codAnimal);
	}
}
