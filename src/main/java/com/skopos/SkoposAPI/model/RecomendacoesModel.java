package com.skopos.SkoposAPI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RECOMENDACOES")
public class RecomendacoesModel {
	@Id
	private int id;
	private String descricao;
	
	@ManyToOne
	PessoaModel pessoa;
	
	public RecomendacoesModel(String descricao, int pessoaId) {
		this.descricao = descricao;
		this.pessoa.setId(pessoaId);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public PessoaModel getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaModel pessoas) {
		this.pessoa = pessoas;
	}
}
