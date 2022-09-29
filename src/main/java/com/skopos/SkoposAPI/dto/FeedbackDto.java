package com.skopos.SkoposAPI.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.skopos.SkoposAPI.model.FeedbackModel;

public class FeedbackDto {
	@NotBlank
	private String feedback;
	@NotNull
	private int idEmpresa;

	@NotNull
	private int idPessoa;
	
	public FeedbackDto() {}
	
	public FeedbackDto(FeedbackModel feedback) {
		this.feedback = feedback.getFeedback();
		this.idEmpresa = feedback.getEmpresa().getId();
		this.idPessoa = feedback.getPessoa().getId();
	}

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

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public List<FeedbackDto> converteListaFeedbackModel(List<FeedbackModel> lista) {
		return lista.stream().map(FeedbackDto::new).collect(Collectors.toList());
	}
}
