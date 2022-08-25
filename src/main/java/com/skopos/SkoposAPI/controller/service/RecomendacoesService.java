package com.skopos.SkoposAPI.controller.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.skopos.SkoposAPI.model.RecomendacoesModel;
import com.skopos.SkoposAPI.repository.RecomendacoesRepository;

public class RecomendacoesService {
	
	@Autowired
	RecomendacoesRepository recomendacoesRepository;
	
	public ResponseEntity cadastraRecomendacao(RecomendacoesModel recomendacoesModel) {
		recomendacoesRepository.save(recomendacoesModel);
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity listaRecomendacaoPorPessoaId(int pessoaId) {
		Optional<RecomendacoesModel> listRecomendacoes = recomendacoesRepository.findByPessoaId(pessoaId);
		if(listRecomendacoes.isPresent()) {
			return ResponseEntity.ok().body(listRecomendacoes.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity removeRecomendacao(int recomendacaoId) {
		recomendacoesRepository.deleteById(recomendacaoId);
		return ResponseEntity.ok().build();
	}
}