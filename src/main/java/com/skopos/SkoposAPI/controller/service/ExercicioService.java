package com.skopos.SkoposAPI.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.skopos.SkoposAPI.dto.PontosExercicioDto;
import com.skopos.SkoposAPI.dto.exercicios.ExercicioLivreDto;
import com.skopos.SkoposAPI.model.ExercicioModel;
import com.skopos.SkoposAPI.model.PessoaModel;
import com.skopos.SkoposAPI.repository.ExercicioRepository;

import java.sql.Date;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExercicioService {
	
	@Autowired
	StravaService stravaService;
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	ExercicioRepository exercicioRepository;
	
	public double getDistancia(String acessToken) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://www.strava.com/api/v3/athlete/activities?access_token="+acessToken;
		
		ResponseEntity<List<ExercicioLivreDto>> exercicioTipo = restTemplate
				.exchange(uri,HttpMethod.GET,null, new ParameterizedTypeReference<List<ExercicioLivreDto>>(){});
		
		double distancia = Double.valueOf(exercicioTipo.getBody()
				.stream()
				.filter(e -> Double.valueOf(e.getDistance()) > 0)
				.collect(Collectors.toList()).get(0).getDistance());
		
		return distancia;
	}
	
	public ExercicioLivreDto getMediaExerciciosPorPessoPorData(int idPessoa, Date dataLimite) {
		double mediaDistancia = 0;
		double mediaTempo = 0;
		int countPessoas = 0;
		List<ExercicioModel> exercicios = exercicioRepository.getMediaAllByPessoaId(idPessoa);
		for(ExercicioModel exer : exercicios) {
			if(exer.getStart_date_local().before(dataLimite)) {
				mediaDistancia = Double.valueOf(exer.getDistance());
				mediaTempo = Double.valueOf(exer.getMoving_time());
				countPessoas++;
			}
		}
		
		ExercicioLivreDto exercicioDto = new ExercicioLivreDto();
		exercicioDto.setDistance(String.valueOf(mediaDistancia/countPessoas));
		exercicioDto.setMoving_time(String.valueOf(mediaTempo/countPessoas));
		
		return exercicioDto;
	}
	
	private List<ExercicioLivreDto> getListExerciciosByUserStrava(String acessToken) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://www.strava.com/api/v3/athlete/activities?access_token="+acessToken;
		List<ExercicioLivreDto> listaExercicios = restTemplate
				.exchange(uri,HttpMethod.GET,null, new ParameterizedTypeReference<List<ExercicioLivreDto>>(){})
				.getBody();
		return listaExercicios;
	}
	
	private int getPontosExercicio(String acessToken){
		double distancia = this.getDistancia(acessToken);
		int pontos = (int) Math.floor(distancia);
		return pontos;
	}
	
	public ResponseEntity aumentaPontosExercicio(String acessToken, int idPessoa) {
		int pontosExercicio = this.getPontosExercicio(acessToken);
		Optional<PessoaModel> pessoa = pessoaService.aumentaNumeroDePontos(idPessoa, pontosExercicio);
		if (pessoa.isPresent()) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();		
	}
	
	public ResponseEntity insereExercicio(String acessToken, int idPessoa) {
		List<ExercicioLivreDto> exercicios = this.getListExerciciosByUserStrava(acessToken);
		for(ExercicioLivreDto e : exercicios) {
			if(this.verificaExercicioNaBase(e.getId())) {
				Optional<PessoaModel> pessoa = pessoaService.buscarPessoaPorId(idPessoa);
				if(pessoa.isPresent()) {
					ExercicioModel exercicioParaInsert;
					try {
						exercicioParaInsert = e.converteParaModel();
						exercicioParaInsert.setPessoa(pessoa.get());
						exercicioRepository.save(exercicioParaInsert);
						this.aumentaPontosExercicio(acessToken, idPessoa);
					} catch (ParseException e1) {
						ResponseEntity.internalServerError();
					}
				}
			}
		}
		return ResponseEntity.ok().build();
	}
	
	private boolean verificaExercicioNaBase(long idExercicio) {
		Optional<ExercicioModel> exercicio = exercicioRepository.findById(idExercicio);
		if(exercicio.isEmpty()) {
			return true;
		}
		return false;
	}
}
