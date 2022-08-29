package br.com.parkusking.petshop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.parkusking.petshop.model.Animal;
import br.com.parkusking.petshop.service.AnimalService;

@RestController
@RequestMapping("animal")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Animal>> listarTodos() {
        List<Animal> res = service.listarTodos();
        if(res != null)  {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{codAnimal}")
    public ResponseEntity<Animal> listarPorId(@PathVariable Long codAnimal) {
        Animal res = service.listarPorId(codAnimal);
        if(res != null)  {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Animal> salvar(@RequestBody Animal animal) {
        Animal res = service.salvar(animal);
        if(res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{codAnimal}")
    public ResponseEntity<Animal> atualizar(@RequestBody Animal animal){
        Animal res = service.alterar(animal);
        if(res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codAnimal}")
	public ResponseEntity<Void> remover(@PathVariable Long codAnimal){
        if(!service.existeId(codAnimal)) {
            return ResponseEntity.notFound().build();
        }
        service.remover(codAnimal);

		return ResponseEntity.noContent().build();
	}
    
}
