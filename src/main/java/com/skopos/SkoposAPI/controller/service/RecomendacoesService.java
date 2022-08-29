package com.skopos.SkoposAPI.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skopos.SkoposAPI.dto.RecomendacaoDto;
import com.skopos.SkoposAPI.model.PessoaModel;
import com.skopos.SkoposAPI.model.RecomendacoesModel;
import com.skopos.SkoposAPI.repository.RecomendacoesRepository;

@Service
public class RecomendacoesService {

	@Autowired
	RecomendacoesRepository recomendacoesRepository;

	@Autowired
	PessoaService pessoaService;

	public ResponseEntity cadastraRecomendacao(RecomendacoesModel recomendacoesModel, int pessoaId) {
		Optional<PessoaModel> pessoa = pessoaService.buscarPessoaPorId(pessoaId);
		if (pessoa.isPresent()) {
			recomendacoesModel.setPessoa(pessoa.get());
			recomendacoesRepository.save(recomendacoesModel);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<List<RecomendacaoDto>> listaRecomendacaoPorPessoaId(int pessoaId) {
		List<RecomendacoesModel> listRecomendacoes = recomendacoesRepository.findByPessoaId(pessoaId);
		if (!listRecomendacoes.isEmpty()) {
			return ResponseEntity.ok().body(new RecomendacaoDto().converter(listRecomendacoes));
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity removeRecomendacao(int recomendacaoId) {
		Optional<RecomendacoesModel> recomendacao = recomendacoesRepository.findById(recomendacaoId);
		if (recomendacao.isPresent()) {
			recomendacoesRepository.deleteById(recomendacaoId);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
