package br.com.parkusking.petshop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.parkusking.petshop.model.Animal;
import br.com.parkusking.petshop.repository.AnimalRepository;



@RestController
@RequestMapping("animal")
public class AnimalController {

    private final AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Animal> listarTodos() {
        return (List<Animal>)repository.findAll();
    }

    @GetMapping(path = "/{cod_animal}")
    public Animal listarPorId(@PathVariable("cod_animal") Long codAnimal) {
        return repository.findById(codAnimal).orElse(null);
    }

    @PostMapping
    public Animal salvar(@RequestBody Animal animal) {
        return repository.save(animal);
    }

    @PutMapping("/{cod_cliente}")
    public Animal alterar(@RequestBody Animal animal){
        return repository.save(animal);
    }

    @DeleteMapping("/{cod_animal}")
	public void remover(@PathVariable("cod_animal") Long codAnimal){
		repository.deleteById(codAnimal);
	}
    
}
