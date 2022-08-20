package com.skopos.SkoposAPI.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.skopos.SkoposAPI.dto.exercicios.CaminhadaDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExercicioService {
	
	@Autowired
	StravaService stravaService;
	
	public double getCalculoExercicio(String acessToken) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://www.strava.com/api/v3/athlete/activities?access_token="+acessToken;
		ResponseEntity<List<CaminhadaDto>> exercicioTipo = restTemplate.exchange(uri,HttpMethod.GET,null, new ParameterizedTypeReference<List<CaminhadaDto>>(){});
		double distancia = Double.valueOf(exercicioTipo.getBody().stream().filter(e -> Double.valueOf(e.getDistance()) > 0).collect(Collectors.toList()).get(0).getDistance());
		
		return distancia;
	}
	
	
	
}
