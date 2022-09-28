package com.skopos.SkoposAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skopos.SkoposAPI.controller.service.AvaliacaoService;

@RestController
@RequestMapping("avaliacao")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@PostMapping("/{idQuestao}/{idOpcao}/{idPessoa}")
	public ResponseEntity<?> enviarAvaliacao(@PathVariable int idQuestao,@PathVariable int idOpcao, @PathVariable int idPessoa){
		return avaliacaoService.cadastraNovaAvaliacao(idQuestao, idOpcao, idPessoa);
	}

	@GetMapping("/{idPessoa}")
	public  ResponseEntity<?> buscarOpcaoQuestao(@PathVariable int idPessoa) {
		return avaliacaoService.buscarAvaliacoesPelaPessoa(idPessoa);
	}
}
