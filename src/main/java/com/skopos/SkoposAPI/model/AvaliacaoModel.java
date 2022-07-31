package com.skopos.SkoposAPI.model;

import java.sql.Date;

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
	private QuestaoModel questoe;
	@ManyToOne
	private OpcaoModel opcao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public QuestaoModel getQuestoe() {
		return questoe;
	}
	public void setQuestoe(QuestaoModel questoe) {
		this.questoe = questoe;
	}
	public OpcaoModel getOpcao() {
		return opcao;
	}
	public void setOpcao(OpcaoModel opcao) {
		this.opcao = opcao;
	}
}
