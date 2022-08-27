package br.com.parkusking.petshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.parkusking.petshop.model.Cliente;
import br.com.parkusking.petshop.repository.ClienteRepository;



@RestController
@RequestMapping("cliente")
public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    @GetMapping(path = "/{cod_cliente}")
    public Optional<Cliente> listarPorId(@PathVariable("cod_cliente") Long codCliente) {
        return repository.findById(codCliente);
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @PutMapping("/{cod_cliente}")
    public Cliente alterar(@RequestBody Cliente cliente){
        return repository.saveAndFlush(cliente);
    }

    @DeleteMapping("/{cod_cliente}")
	public void remover(@PathVariable("cod_cliente") Long codCliente){
		repository.deleteById(codCliente);
	}
}
