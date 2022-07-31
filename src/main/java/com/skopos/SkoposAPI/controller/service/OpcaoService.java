package com.skopos.SkoposAPI.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skopos.SkoposAPI.model.OpcaoModel;
import com.skopos.SkoposAPI.model.QuestaoModel;
import com.skopos.SkoposAPI.repository.OpcaoRepository;
import com.skopos.SkoposAPI.repository.QuestaoRepository;

@Service
public class OpcaoService {
	@Autowired
	OpcaoRepository opcaoRepository;
	
	@Autowired
	QuestaoRepository questaoRepository;
	
	public void cadastroOpcao(OpcaoModel opcaoModel, int idQuestao) {
		QuestaoModel questaoModel = questaoRepository.findById(idQuestao).get();
		if(questaoModel != null) {
			opcaoModel.setQuestao(questaoModel);
			opcaoRepository.save(opcaoModel);
		}
	}
}
