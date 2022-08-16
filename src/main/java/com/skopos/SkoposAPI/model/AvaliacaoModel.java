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

	public AvaliacaoModel (QuestaoModel questao, OpcaoModel opcao) {
		this.questao = questao;
		this.opcao = opcao;
        data = Date.valueOf(LocalDate.now());
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
}
