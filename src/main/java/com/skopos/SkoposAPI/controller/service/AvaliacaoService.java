package com.skopos.SkoposAPI.controller.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.skopos.SkoposAPI.model.AvaliacaoModel;
import com.skopos.SkoposAPI.model.OpcaoModel;
import com.skopos.SkoposAPI.model.QuestaoModel;
import com.skopos.SkoposAPI.repository.AvaliacaoRepository;
import com.skopos.SkoposAPI.repository.OpcaoRepository;
import com.skopos.SkoposAPI.repository.QuestaoRepository;

public class AvaliacaoService {
	@Autowired
	AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	QuestaoRepository questaoRepository;
	
	@Autowired
	OpcaoRepository opcaoRepository;
	
	public ResponseEntity<?> cadastraNovaAvaliacao(int idQuestao, int idOpcao) {
		Optional<QuestaoModel> questao = questaoRepository.findById(idQuestao);
		Optional<OpcaoModel> opcao = opcaoRepository.findById(idOpcao);
		
		if(opcao.isPresent() && questao.isPresent()) {
			avaliacaoRepository.save(new AvaliacaoModel(questao.get(), opcao.get()));
			return ResponseEntity.created(null).build();
		}
		return ResponseEntity.badRequest().build();
		
	}
}
