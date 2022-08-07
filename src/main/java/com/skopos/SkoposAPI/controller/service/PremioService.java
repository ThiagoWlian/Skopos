package com.skopos.SkoposAPI.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skopos.SkoposAPI.model.EmpresaModel;
import com.skopos.SkoposAPI.model.PessoaModel;
import com.skopos.SkoposAPI.model.PremioModel;
import com.skopos.SkoposAPI.repository.EmpresaRepository;
import com.skopos.SkoposAPI.repository.PremioRepository;

@Service
public class PremioService {

	@Autowired
	PremioRepository premioRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	PessoaService pessoaService;
	
	public void cadastroPremio(PremioModel premioModel, String cnpj) {
		EmpresaModel empresaModel = empresaRepository.findByCnpj(cnpj);
		premioModel.setEmpresa(empresaModel);
		premioRepository.save(premioModel);
	}
	
	public void enviaPremio(int idPremio, int idPessoa) {
		PremioModel premio = premioRepository.findById(idPremio).get();
		if(premio.getQuantidadeDisponivel() > 0) {
			PessoaModel pessoa = pessoaService.buscarPessoaPorId(idPessoa).get();
			premio.setPessoas(pessoa);
			premioRepository.save(premio);
		}
	}
	
	public Page<PremioModel> listaTodosOsPremios(Pageable page) {
		Page<PremioModel> listaPremios = premioRepository.findAll(page);
		return listaPremios;
	}
}
