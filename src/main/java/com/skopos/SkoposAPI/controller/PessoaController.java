package com.skopos.SkoposAPI.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.skopos.SkoposAPI.dto.PaiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.PermissaoService;
import com.skopos.SkoposAPI.controller.service.PessoaService;
import com.skopos.SkoposAPI.dto.CadastroPessoaCompletoForm;
import com.skopos.SkoposAPI.dto.PontosDto;
import com.skopos.SkoposAPI.model.PessoaModel;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	PermissaoService permissaoService;
	
	@PostMapping
	public ResponseEntity<CadastroPessoaCompletoForm> cadastraPessoa(@RequestBody @Valid CadastroPessoaCompletoForm pessoaForm) {
		pessoaService.cadastraPessoa(pessoaForm.converterParaEndereco(), pessoaForm.converterParaUsuario(), pessoaForm.converterParaPessoa(), pessoaForm.converterParaPermissao(), pessoaForm.converterParaChavePix(),pessoaForm.converterParaEmpresa().getId());
		permissaoService.cadastraPermissao(pessoaForm.converterParaPermissao());
		return ResponseEntity.created(null).body(pessoaForm);
	}
	
	@GetMapping("/buscarPontos/{idPessoa}")
	public ResponseEntity<PontosDto> buscarPontosDaPessoa(@PathVariable int idPessoa){
		PontosDto pontosRetorno = new PontosDto();
		pontosRetorno.setPontos(pessoaService.buscaPontosPessoaPorId(idPessoa));
		return ResponseEntity.ok(pontosRetorno);
	}
	
	@PutMapping("/aumentarPontos/{idPessoa}/{numeroPontos}")
	public ResponseEntity<PontosDto> aumentaNumeroDePontos(@PathVariable int numeroPontos, @PathVariable int idPessoa){
		Optional<PessoaModel> pessoa = pessoaService.aumentaNumeroDePontos(idPessoa, numeroPontos);
		if(pessoa.isPresent()) {
			PontosDto pontosRetorno = new PontosDto();
			pontosRetorno.setPontos(pessoa.get().getPontos());
			return ResponseEntity.ok(pontosRetorno);
		 }
		 return ResponseEntity.notFound().build();
	}
	
	@GetMapping("{idPessoa}")
	public ResponseEntity<?> buscarPessoaPorId(@PathVariable int idPessoa) {
		return pessoaService.findPessoaPorId(idPessoa);
	}

	@GetMapping("/pai/{idPessoa}")
	public ResponseEntity<?> buscarPaiPorPessoaId(@PathVariable int idPessoa) {
		return ResponseEntity.ok(new PaiDto(pessoaService.buscaPaiPessoaPorId(idPessoa)));
	}

	@GetMapping
	public ResponseEntity<?> buscarPessoaPorId() {
		return pessoaService.buscarTodasPessoa();
	}
	
}
