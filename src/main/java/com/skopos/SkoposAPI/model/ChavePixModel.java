package com.skopos.SkoposAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CHAVE_PIX")
public class ChavePixModel {
	@Id
	private String chave;
	@ManyToOne
	private PessoaModel pessoa;
	
	public ChavePixModel() {
		
	}
	
	public ChavePixModel(String chave) {
		this.chave = chave;
	}
	
	public String getChave() {
		return chave;
	}
	
	public void setChave(String chave) {
		this.chave = chave;
	}

	public PessoaModel getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaModel pessoa) {
		this.pessoa = pessoa;
	}
	
}
