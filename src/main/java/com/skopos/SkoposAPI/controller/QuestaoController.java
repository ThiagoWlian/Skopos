package com.skopos.SkoposAPI.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.QuestaoService;
import com.skopos.SkoposAPI.dto.CadastroQuestaoDto;
import com.skopos.SkoposAPI.dto.CadastroQuestaoForm;
import com.skopos.SkoposAPI.dto.QuestaoDto;
import com.skopos.SkoposAPI.model.QuestaoModel;

@RestController
@RequestMapping("/questao")
public class QuestaoController {
	
	@Autowired
	QuestaoService questaoService;
	
	@PostMapping("/cadastro")
	public ResponseEntity<CadastroQuestaoDto> cadastraQuestao(@RequestBody @Valid CadastroQuestaoForm questaoForm) {
		QuestaoModel questao = questaoService.cadastraQuestao(questaoForm.converteParaQuestaoModel(), questaoForm.getId());
		return ResponseEntity.ok().body(new CadastroQuestaoDto(questaoForm, questao.getID()));
	}
	
	@GetMapping("/{idEmpresa}")
	public ResponseEntity<List<QuestaoDto>> listaQuestoesAtivasPorEmpresa(@PathVariable int idEmpresa){
		List<QuestaoModel> questoesModel = questaoService.buscaQuestoesAtivasPorEmpresaPorUsuario(idEmpresa);
		
		return ResponseEntity.ok(new QuestaoDto().converteQuestaoModelParaQuestaoDto(questoesModel));
	}
}
