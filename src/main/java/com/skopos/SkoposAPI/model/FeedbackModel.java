package com.skopos.SkoposAPI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FEEDBACK")
public class FeedbackModel {
	@Id
	private int id;
	
	private String feedback;
	
	@ManyToOne
	private EmpresaModel empresa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public EmpresaModel getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaModel empresa) {
		this.empresa = empresa;
	}
	
}
