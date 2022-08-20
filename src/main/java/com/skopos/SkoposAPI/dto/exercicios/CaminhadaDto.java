package com.skopos.SkoposAPI.dto.exercicios;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaminhadaDto implements ExercicioDto{
	@JsonProperty
	private String distance;
	@JsonProperty
	private String moving_time;
	
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
}
