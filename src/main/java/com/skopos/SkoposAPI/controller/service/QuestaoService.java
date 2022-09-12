package com.skopos.SkoposAPI.controller.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

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
	private OpcaoService opcaoService;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Transactional
	public QuestaoModel cadastraQuestao(QuestaoModel questaoModel, int id) {
		EmpresaModel empresaModel = empresaRepository.findById(id).get();
		questaoModel.setEmpresa(empresaModel);
		QuestaoModel questao = questaoRepository.save(questaoModel);
		return questao;
	}
	
	public List<QuestaoModel> buscaQuestoesAtivasPorEmpresaPorUsuario(int idEmpresa) {
		return questaoRepository.findByEmpresaStatus(idEmpresa, Date.valueOf(LocalDate.now()));
	}
}
