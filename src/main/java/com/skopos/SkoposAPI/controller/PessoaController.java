package com.skopos.SkoposAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.PermissaoService;
import com.skopos.SkoposAPI.controller.service.PessoaService;
import com.skopos.SkoposAPI.dto.CadastroEmpresaDto;
import com.skopos.SkoposAPI.dto.CadastroPessoaCompletoForm;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	PermissaoService permissaoService;
	
	@PostMapping
	public ResponseEntity<CadastroPessoaCompletoForm> cadastraPessoa(@RequestBody @Valid CadastroPessoaCompletoForm pessoaForm) {
		pessoaService.cadastraPessoa(pessoaForm.converterParaEndereco(), pessoaForm.converterParaUsuario(), pessoaForm.converterParaPessoa(), pessoaForm.converterParaPermissao(),pessoaForm.converterParaEmpresa().getCnpj());
		permissaoService.cadastraPermissao(pessoaForm.converterParaPermissao());
		return ResponseEntity.created(null).body(pessoaForm);
	}
}
