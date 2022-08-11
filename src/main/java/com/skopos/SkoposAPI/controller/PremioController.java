package com.skopos.SkoposAPI.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.PremioService;
import com.skopos.SkoposAPI.dto.CadastroPremioDto;
import com.skopos.SkoposAPI.dto.CadastroPremioForm;
import com.skopos.SkoposAPI.dto.PremiosDto;
import com.skopos.SkoposAPI.model.PremioModel;


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
	
	@GetMapping
	public ResponseEntity<List<PremiosDto>> buscaTodosOsPremios(){
		List<PremioModel> listaPremios = premioService.listaTodosOsPremios();
		if(listaPremios.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new PremiosDto().converter(listaPremios));
	}
	
	@GetMapping("/buscarPremio/{idPessoa}")
	public ResponseEntity<List<PremiosDto>> buscaTodosOsPremiosPorPessoaId(@PathVariable int idPessoa){
		List<PremioModel> listaPremios = premioService.listaTodosOsPremiosPorPessoa(idPessoa);
		if(listaPremios.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new PremiosDto().converter(listaPremios));
	}
	
}
