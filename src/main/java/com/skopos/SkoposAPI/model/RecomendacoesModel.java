package com.skopos.SkoposAPI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "RECOMENDACOES")
public class RecomendacoesModel {
	@Id
	private int id;
	private String descricao;
	
	@ManyToOne
	PessoaModel pessoas;
	
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
	public PessoaModel getPessoas() {
		return pessoas;
	}
	public void setPessoas(PessoaModel pessoas) {
		this.pessoas = pessoas;
	}
}
