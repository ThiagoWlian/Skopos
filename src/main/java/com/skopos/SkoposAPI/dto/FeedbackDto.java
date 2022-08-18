package com.skopos.SkoposAPI.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FeedbackDto {
	@NotBlank
	private String feedback;
	@NotNull
	private int idEmpresa;

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
}
