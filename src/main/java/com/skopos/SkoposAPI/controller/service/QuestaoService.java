package com.skopos.SkoposAPI.controller.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skopos.SkoposAPI.dto.DadosOpcaoQuestaoDto;
import com.skopos.SkoposAPI.dto.QuestaoDto;
import com.skopos.SkoposAPI.dto.RespostasQuestoesDto;
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
	
	public ResponseEntity<List<RespostasQuestoesDto>> listaRespostasQuestoes(){
		List<QuestaoDto> listQuestoes = questaoRepository.findNomeById();
		List<RespostasQuestoesDto> listRespostas = new ArrayList<RespostasQuestoesDto>();

		for (QuestaoDto questao : listQuestoes) {
			List<DadosOpcaoQuestaoDto> listaDadosOpcoes = questaoRepository.countOpcoesPorAvaliacao(Integer.valueOf(questao.getIdQuestao()));
			if(!listaDadosOpcoes.isEmpty()) {
				RespostasQuestoesDto respostasDto = new RespostasQuestoesDto(questao.getQuestao(), listaDadosOpcoes);
				listRespostas.add(respostasDto);
			}
		}
		
		return ResponseEntity.ok(listRespostas);
		
	}
}
