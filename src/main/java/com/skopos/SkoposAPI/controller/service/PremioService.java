package com.skopos.SkoposAPI.controller.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.skopos.SkoposAPI.repository.PessoaRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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

	@Autowired
	PessoaRepositoy pessoaRepositoy;

	
	public void cadastroPremio(PremioModel premioModel, int id) {
		EmpresaModel empresaModel = empresaRepository.findById(id).get();
		premioModel.setEmpresa(empresaModel);
		premioRepository.save(premioModel);
	}
	
	@Transactional
	public ResponseEntity enviaPremio(int idPremio, int idPessoa) {
		Optional<PremioModel> premio = premioRepository.findById(idPremio);
		Optional<PessoaModel> pessoa = pessoaService.buscarPessoaPorId(idPessoa);
		if(premio.get().getQuantidadeDisponivel() > 0 && premio.get().getValor() < pessoa.get().getPontos()) {
			PremioModel premioModel = premio.get();
			PessoaModel pessoaModel = pessoa.get();
			pessoaModel.addPremio(premioModel);
			pessoaModel.setPontos((long)(pessoaModel.getPontos() - premioModel.getValor()));
			premioModel.setQuantidadeDisponivel(premio.get().getQuantidadeDisponivel()-1);
			pessoaRepositoy.save(pessoaModel);
			return ResponseEntity.ok().body(null);
		}
		return ResponseEntity.status(406).body(null);
	}
	
	public List<PremioModel> listaTodosOsPremios() {
		List<PremioModel> listaPremios = premioRepository.findAll();
		return listaPremios;
	}
	
	public List<PremioModel> listaTodosOsPremiosPorPessoa(int idPessoa) {
		List<PremioModel> listaPremios = premioRepository.findPremiosEnviadosPorUsuarioId(idPessoa);
		return listaPremios;
	}
}
