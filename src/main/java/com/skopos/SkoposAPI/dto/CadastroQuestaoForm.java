package com.skopos.SkoposAPI.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.skopos.SkoposAPI.model.EmpresaModel;
import com.skopos.SkoposAPI.model.QuestaoModel;

public class CadastroQuestaoForm {
	@NotBlank
	private String questao;
	@NotNull
	private Date dataExpiracao;
	@NotNull
	private int id;
	
	public QuestaoModel converteParaQuestaoModel() {
		return new QuestaoModel(questao, dataExpiracao);
	}
	
	public EmpresaModel converteParaEmpresaModel() {
		return new EmpresaModel(id);
	}
	
	public String getQuestao() {
		return questao;
	}
	public void setQuestao(String questao) {
		this.questao = questao;
	}
	public Date getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
