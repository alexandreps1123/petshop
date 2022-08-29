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

import br.com.parkusking.petshop.dto.ClienteDTO;
import br.com.parkusking.petshop.model.Cliente;
import br.com.parkusking.petshop.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        List<Cliente> res = service.listarTodos();
        if(res != null)  {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/dto")
    public List<ClienteDTO> listarTodosDTO() {
        List<ClienteDTO> res = service.listarTodosDTO();
        
        return res;        
    }

    @GetMapping("/{codCliente}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable Long codCliente) {
        Cliente res = service.listarPorId(codCliente);
        if(res != null)  {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        Cliente res = service.salvar(cliente);
        if(res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{codCliente}")
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente){
        Cliente res = service.alterar(cliente);
        if(res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codCliente}")
	public ResponseEntity<Void> remover(@PathVariable Long codCliente){
        if(!service.existeId(codCliente)) {
            return ResponseEntity.notFound().build();
        }
        service.remover(codCliente);

		return ResponseEntity.noContent().build();
	}
}
