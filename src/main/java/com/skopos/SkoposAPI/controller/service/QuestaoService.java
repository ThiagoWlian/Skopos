package com.skopos.SkoposAPI.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skopos.SkoposAPI.model.EmpresaModel;
import com.skopos.SkoposAPI.model.QuestaoModel;
import com.skopos.SkoposAPI.repository.EmpresaRepository;
import com.skopos.SkoposAPI.repository.QuestaoRepository;

@Service
public class QuestaoService {
	@Autowired
	private QuestaoRepository questaoRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public void cadastraQuestao(QuestaoModel questaoModel, String cnpj) {
		EmpresaModel empresaModel = empresaRepository.findByCnpj(cnpj);
		questaoModel.setEmpresa(empresaModel);
		questaoRepository.save(questaoModel);
	}
	
	public QuestaoModel buscaQuestoesAtivasPorEmpresaPorUsuario(int idEmpresa) {
		return null;
	}
}
