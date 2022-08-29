package br.com.parkusking.petshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.parkusking.petshop.dto.ClienteDTO;
import br.com.parkusking.petshop.model.Cliente;
import br.com.parkusking.petshop.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listarTodos() {
        return (List<Cliente>)repository.findAll();
    }

    public List<ClienteDTO> listarTodosDTO() {
        return repository.listarTodosDTO();
    }
    
    public Cliente listarPorId(Long codCliente) {
        return repository.findById(codCliente).orElse(null);
    }

    public boolean existeId(Long codCliente) {
        return repository.existsById(codCliente);
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    @Transactional
    public Cliente alterar(Cliente cliente){
        return repository.save(cliente);
    }

    @Transactional
	public void remover(Long codCliente){
        repository.deleteById(codCliente);
	}
}
