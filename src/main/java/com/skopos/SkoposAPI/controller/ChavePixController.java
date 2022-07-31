package com.skopos.SkoposAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.ChavePixService;
import com.skopos.SkoposAPI.dto.CadastraChavePixForm;

@RestController
@RequestMapping("/pix")
public class ChavePixController {
	
	@Autowired
	ChavePixService chavePixService;
	
	@PostMapping("/cadastro")
	public ResponseEntity<CadastraChavePixForm> cadastroChavePix(@RequestBody @Valid CadastraChavePixForm chavePixForm) {
		chavePixService.cadastraChavePix(chavePixForm.converteParaChavePixModel(), chavePixForm.getIdPessoa());
		return null;
	}
}
