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

import br.com.parkusking.petshop.model.OrdemServico;
import br.com.parkusking.petshop.repository.OrdemServicoRepository;


@RestController
@RequestMapping("ordem_servico")
public class OrdemServicoController {

    private final OrdemServicoRepository repository;

    public OrdemServicoController(OrdemServicoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<OrdemServico> listarTodos() {
        return repository.findAll();
    }

    @GetMapping(path = "/{cod_ordem_servico}")
    public Optional<OrdemServico> listarPorId(@PathVariable("cod_ordem_servico") Long codOrdemServico) {
        return repository.findById(codOrdemServico);
    }

    @PostMapping
    public OrdemServico salvar(@RequestBody OrdemServico ordemServico) {
        return repository.save(ordemServico);
    }

    @PutMapping("/{cod_ordem_servico}")
    public OrdemServico alterar(@PathVariable("cod_ordem_servico") Long codOrdemServico, @RequestBody OrdemServico ordemServicoDetalhes){
        OrdemServico ordemServicoAlterar = repository.findById(codOrdemServico)
        .orElseThrow();

        ordemServicoAlterar.setValor(ordemServicoDetalhes.getValor());
        ordemServicoAlterar.setHoraEntrada(ordemServicoDetalhes.getHoraEntrada());
        ordemServicoAlterar.setHoraRetirada(ordemServicoDetalhes.getHoraRetirada());

        return repository.saveAndFlush(ordemServicoAlterar);
    }

    @DeleteMapping("/{cod_ordem_servico}")
	public void remover(@PathVariable("cod_ordem_servico") Long codOrdemServico){
		repository.deleteById(codOrdemServico);
	}
}