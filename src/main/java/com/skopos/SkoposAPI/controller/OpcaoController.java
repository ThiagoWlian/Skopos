package com.skopos.SkoposAPI.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.OpcaoService;
import com.skopos.SkoposAPI.dto.CadastroOpcaoDto;
import com.skopos.SkoposAPI.dto.CadastroOpcaoForm;

@RestController
@RequestMapping("/opcao")
public class OpcaoController {
	@Autowired
	OpcaoService opcaoService;
	
	@PostMapping("/cadastro")
	public ResponseEntity<CadastroOpcaoDto> cadastraPessoa(@RequestBody @Valid CadastroOpcaoForm opcaoForm) {
		opcaoService.cadastroOpcao(opcaoForm.converteParaOpcaoModel(), opcaoForm.converteParaQuestao().getID());
		return ResponseEntity.created(null).body(new CadastroOpcaoDto(opcaoForm.converteParaOpcaoModel()));
	}
	
	@PostMapping("/cadastroLista")
	public ResponseEntity<List<CadastroOpcaoForm>> cadastraPessoa(@RequestBody @Valid List<CadastroOpcaoForm> opcaoFormList) {
		for(CadastroOpcaoForm opcaoForm : opcaoFormList) {
			opcaoService.cadastroOpcao(opcaoForm.converteParaOpcaoModel(), opcaoForm.converteParaQuestao().getID());
		}
		return ResponseEntity.created(null).body(opcaoFormList);
	}
}
