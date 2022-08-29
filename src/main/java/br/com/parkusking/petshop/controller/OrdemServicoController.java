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

import br.com.parkusking.petshop.model.OrdemServico;
import br.com.parkusking.petshop.service.OrdemServicoService;


@RestController
@RequestMapping("ordemServico")
public class OrdemServicoController {

    private final OrdemServicoService service;

    public OrdemServicoController(OrdemServicoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OrdemServico>> listarTodos() {
        List<OrdemServico> res = service.listarTodos();
        if(res != null)  {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{codOrdemServico}")
    public ResponseEntity<OrdemServico> listarPorId(@PathVariable Long codOrdemServico) {
        OrdemServico res = service.listarPorId(codOrdemServico);
        if(res != null)  {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrdemServico> salvar(@RequestBody OrdemServico ordemServico) {
        OrdemServico res = service.salvar(ordemServico);
        if(res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{codOrdemServico}")
    public ResponseEntity<OrdemServico> atualizar(@RequestBody OrdemServico ordemServico){
        OrdemServico res = service.alterar(ordemServico);
        if(res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codOrdemServico}")
	public ResponseEntity<Void> remover(@PathVariable Long codOrdemServico){
        if(!service.existeId(codOrdemServico)) {
            return ResponseEntity.notFound().build();
        }
        service.remover(codOrdemServico);

		return ResponseEntity.noContent().build();
	}

}