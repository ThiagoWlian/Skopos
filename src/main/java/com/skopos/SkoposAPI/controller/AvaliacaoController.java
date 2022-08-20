package com.skopos.SkoposAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.AvaliacaoService;

@RestController
@RequestMapping("avaliacao")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@PostMapping("/{idQuestao}/{idOpcao}")
	public ResponseEntity<?> enviarAvaliacao(@PathVariable int idQuestao,@PathVariable int idOpcao){
		return avaliacaoService.cadastraNovaAvaliacao(idQuestao, idOpcao);
	}
}
