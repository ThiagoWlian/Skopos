package com.skopos.SkoposAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.EmpresaService;
import com.skopos.SkoposAPI.controller.service.ExercicioService;
import com.skopos.SkoposAPI.controller.service.StravaService;
import com.skopos.SkoposAPI.dto.CadastroEmpresaDto;
import com.skopos.SkoposAPI.dto.CadastroEmpresaForm;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	EmpresaService empresaService;
	
	@Autowired
	StravaService strava;
	
	@PostMapping
	public ResponseEntity cadastrarEmpresa(@RequestBody @Valid CadastroEmpresaForm empresaForm){
		return empresaService.cadastraEmpresa(empresaForm.converterParaEndereco(),empresaForm.converterParaEmpresa());
	}
	
	@GetMapping
	public ResponseEntity<CadastroEmpresaDto> buscarEmpresa(){
		ResponseEntity response = empresaService.buscaTodasEmpresas();
		return response;
	}
	
	@GetMapping("/{idEmpresa}")
	public ResponseEntity<CadastroEmpresaDto> buscarEmpresaPorId(@PathVariable int idEmpresa){
		ResponseEntity response = empresaService.buscaEmpresaPorId(idEmpresa);
		return response;
	}
	
	@GetMapping("/buscarPorCnpj/{cnpj}")
	public ResponseEntity<CadastroEmpresaDto> buscarEmpresaPorId(@PathVariable String cnpj){
		ResponseEntity response = empresaService.buscaEmpresaPorCnpj(cnpj);
		return response;
	}

}
