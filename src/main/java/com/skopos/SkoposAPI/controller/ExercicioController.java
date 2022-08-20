package com.skopos.SkoposAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.ExercicioService;
import com.skopos.SkoposAPI.controller.service.StravaService;
import com.skopos.SkoposAPI.dto.exercicios.CaminhadaDto;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {
	
	@Autowired
	ExercicioService exercicioService;
	
	@Autowired
	StravaService stravaService;
	
	@GetMapping("/{code}")
	public ResponseEntity<?> buscarCalculoPontos(@PathVariable String code){
		String acessToken = stravaService.getAcessToekenStrava(code);
		if(!(acessToken.isBlank() || acessToken.isEmpty())) {
			double calculoPontos = exercicioService.getCalculoExercicio(acessToken);
			return ResponseEntity.ok(calculoPontos);
		}
		return ResponseEntity.badRequest().build();
	}
}
