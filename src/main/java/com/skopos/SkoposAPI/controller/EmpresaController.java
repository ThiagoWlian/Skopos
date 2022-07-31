package com.skopos.SkoposAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.EmpresaService;
import com.skopos.SkoposAPI.dto.CadastroEmpresaDto;
import com.skopos.SkoposAPI.dto.CadastroEmpresaForm;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	EmpresaService empresaService;
	
	@PostMapping
	public ResponseEntity<CadastroEmpresaDto> cadastrarProduto(@RequestBody @Valid CadastroEmpresaForm empresaForm){
		empresaService.cadastraEmpresa(empresaForm.converterParaEndereco(),empresaForm.converterParaEmpresa());
		return ResponseEntity.created(null).body(new CadastroEmpresaDto(empresaForm));
	}

}
