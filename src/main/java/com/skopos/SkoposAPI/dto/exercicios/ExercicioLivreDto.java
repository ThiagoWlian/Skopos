package com.skopos.SkoposAPI.dto.exercicios;

import java.text.ParseException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skopos.SkoposAPI.model.ExercicioModel;

public class ExercicioLivreDto implements ExercicioDto{
	
	@JsonProperty
	private long id;
	@JsonProperty
	private String sport_type;
	@JsonProperty
	private String distance;
	@JsonProperty
	private String moving_time;
	@JsonProperty
	private String start_date_local;
	
	public double calculoPontos() {
		return Double.valueOf(distance) / Double.valueOf(moving_time);
	}
	
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getMoving_time() {
		return moving_time;
	}
	public void setMoving_time(String moving_time) {
		this.moving_time = moving_time;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSport_type() {
		return sport_type;
	}

	public void setSport_type(String sport_type) {
		this.sport_type = sport_type;
	}

	public String getStart_date_local() {
		return start_date_local;
	}

	public void setStart_date_local(String start_date_local) {
		String data = start_date_local.split("T")[0];
		this.start_date_local = data;
	}
	
	public ExercicioModel converteParaModel() throws ParseException {
		return new ExercicioModel(id, sport_type, Double.valueOf(distance), Double.valueOf(moving_time), start_date_local);
	}

	@Override
	public String toString() {
		return "Tipo: " + sport_type;
	}
}
