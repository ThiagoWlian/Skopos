package com.skopos.SkoposAPI.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.RecomendacoesService;
import com.skopos.SkoposAPI.dto.RecomendacaoDto;

@RestController
@RequestMapping("/recomendacoes")
public class RecomendacoesController {
	
	@Autowired
	private RecomendacoesService recomendacoesService;
	
	@PostMapping("/cadastro")
	public ResponseEntity cadastrarRecomendacao(@RequestBody @Valid RecomendacaoDto recomendacao){
		return recomendacoesService.cadastraRecomendacao(recomendacao.converteParaRecomendacaoModel(), recomendacao.getIdPessoa());
	}
	
	@GetMapping("/{pessoaId}")
	public ResponseEntity getRecomendacoesPorPessoa(@PathVariable int pessoaId) {
		return recomendacoesService.listaRecomendacaoPorPessoaId(pessoaId);
	}
	
	@DeleteMapping("/{pessoaId}")
	public ResponseEntity deletarRecomendacao(@PathVariable int pessoaId) {
		return recomendacoesService.removeRecomendacao(pessoaId);
	}
	
}
