package com.skopos.SkoposAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.QuestaoService;
import com.skopos.SkoposAPI.dto.CadastroPremioDto;
import com.skopos.SkoposAPI.dto.CadastroPremioForm;
import com.skopos.SkoposAPI.dto.CadastroQuestaoDto;
import com.skopos.SkoposAPI.dto.CadastroQuestaoForm;

@RestController
@RequestMapping("/questao")
public class QuestaoController {
	
	@Autowired
	QuestaoService questaoService;
	
	@PostMapping("/cadastro")
	public ResponseEntity<CadastroQuestaoDto> cadastraQuestao(@RequestBody @Valid CadastroQuestaoForm questaoForm) {
		questaoService.cadastraQuestao(questaoForm.converteParaQuestaoModel(), questaoForm.getCnpj());
		return ResponseEntity.ok().body(new CadastroQuestaoDto(questaoForm));
	}
}
