package com.skopos.SkoposAPI.dto;

public class PontosExercicioDto {
	private int pontosGerados;

	public PontosExercicioDto(int pontosGerados) {
		super();
		this.pontosGerados = pontosGerados;
	}

	public int getPontosGerados() {
		return pontosGerados;
	}
	
	public void setPontosGerados(int pontosGerados) {
		this.pontosGerados = pontosGerados;
	}
}
