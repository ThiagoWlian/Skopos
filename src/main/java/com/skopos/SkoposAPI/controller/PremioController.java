package com.skopos.SkoposAPI.controller;


import java.util.List;

import javax.validation.Valid;

import com.skopos.SkoposAPI.dto.PremioListaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
		premioService.cadastroPremio(premioForm.converteParaPremioModel(), premioForm.getId());// o id é da empresa
		return ResponseEntity.created(null).body(new CadastroPremioDto(premioForm));
	}
	
	@PostMapping("/enviarPremio/{idPessoa}/{idPremio}")
	public ResponseEntity enviaPremio(@PathVariable int idPessoa, @PathVariable int idPremio) {
		ResponseEntity response = premioService.enviaPremio(idPremio, idPessoa);
		return response;
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

	@GetMapping("/buscarPremiosUsuario/{idPessoa}")
	public ResponseEntity<List<PremioListaDto>> buscarPremiosParaUsuario(@PathVariable int idPessoa) {
		return ResponseEntity.ok(premioService.listarPremiosDoUsuario(idPessoa));
	}

	@GetMapping("/buscarPremiosEnvio/{idEmpresa}")
	public ResponseEntity<List<PremioListaDto>> buscarPremiosParaEnvio(@PathVariable int idEmpresa) {
		return ResponseEntity.ok(premioService.listarPremiosParaEnviar(idEmpresa));
	}

	@PutMapping("/atualizarStatus/{idPremio}")
	public ResponseEntity<?> atualizarStatus(@PathVariable int idPremio) {
		return premioService.atualizarStatuPremio(idPremio);
	}
}
