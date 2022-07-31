package com.skopos.SkoposAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.PremioService;
import com.skopos.SkoposAPI.dto.CadastroEmpresaDto;
import com.skopos.SkoposAPI.dto.CadastroPessoaCompletoForm;
import com.skopos.SkoposAPI.dto.CadastroPremioDto;
import com.skopos.SkoposAPI.dto.CadastroPremioForm;

@RestController
@RequestMapping("/premio")
public class PremioController {
	
	@Autowired
	PremioService premioService;
	
	@PostMapping
	public ResponseEntity<CadastroPremioDto> cadastraPremio(@RequestBody @Valid CadastroPremioForm premioForm) {
		premioService.cadastroPremio(premioForm.converteParaPremioModel(), premioForm.getCnpj());
		return ResponseEntity.created(null).body(new CadastroPremioDto(premioForm));
	}
	
	@PostMapping("/enviarPremio/{idPessoa}/{idPremio}")
	public ResponseEntity<CadastroPremioDto> cadastraPremio(@PathVariable int idPessoa, @PathVariable int idPremio) {
		premioService.enviaPremio(idPremio, idPessoa);
		return ResponseEntity.ok().body(null);
	}
}
