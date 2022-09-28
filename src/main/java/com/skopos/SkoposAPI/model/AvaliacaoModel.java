package com.skopos.SkoposAPI.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AVALIACAO")
public class AvaliacaoModel {
	@Id
	private int id;
	private Date data;
	@ManyToOne
	private QuestaoModel questao;
	@ManyToOne
	private OpcaoModel opcao;
	@ManyToOne
	private PessoaModel pessoa;

	public AvaliacaoModel (QuestaoModel questao, OpcaoModel opcao, PessoaModel pessoa) {
		this.questao = questao;
		this.opcao = opcao;
		this.pessoa = pessoa;
        data = Date.valueOf(LocalDate.now());
	}

	public AvaliacaoModel() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}


	public QuestaoModel getQuestao() {
		return questao;
	}

	public void setQuestao(QuestaoModel questao) {
		this.questao = questao;
	}

	public OpcaoModel getOpcao() {
		return opcao;
	}

	public void setOpcao(OpcaoModel opcao) {
		this.opcao = opcao;
	}

	public PessoaModel getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaModel pessoa) {
		this.pessoa = pessoa;
	}
}
