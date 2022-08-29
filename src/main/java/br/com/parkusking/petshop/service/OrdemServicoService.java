package br.com.parkusking.petshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.parkusking.petshop.model.OrdemServico;
import br.com.parkusking.petshop.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository repository;

    public OrdemServicoService(OrdemServicoRepository repository) {
        this.repository = repository;
    }

    public List<OrdemServico> listarTodos() {
        return (List<OrdemServico>)repository.findAll();
    }
    
    public OrdemServico listarPorId(Long codOrdemServico) {
        return repository.findById(codOrdemServico).orElse(null);
    }

    public boolean existeId(Long codOrdemServico) {
        return repository.existsById(codOrdemServico);
    }

    @Transactional
    public OrdemServico salvar(OrdemServico ordemServico) {
        return repository.save(ordemServico);
    }

    @Transactional
    public OrdemServico alterar(OrdemServico ordemServico){
        return repository.save(ordemServico);
    }

    @Transactional
	public void remover(Long codOrdemServico){
        repository.deleteById(codOrdemServico);
	}
}
