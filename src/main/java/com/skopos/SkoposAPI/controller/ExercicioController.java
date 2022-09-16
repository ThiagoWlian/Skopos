package com.skopos.SkoposAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.ExercicioService;
import com.skopos.SkoposAPI.controller.service.StravaService;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {
	
	@Autowired
	ExercicioService exercicioService;
	
	@Autowired
	StravaService stravaService;
	
	@PostMapping("/{code}/{idPessoa}")
	public ResponseEntity<?> sincronizarExercicios(@PathVariable String code, @PathVariable int idPessoa){
		String acessToken = stravaService.getAcessToekenStrava(code);
		return exercicioService.insereExercicio(acessToken, idPessoa);
	}
}
