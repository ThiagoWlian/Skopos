package com.skopos.SkoposAPI.dto;

import java.sql.Date;

public class CadastroQuestaoDto {
	private String questao;
	private Date dataExpiracao;
	
	public CadastroQuestaoDto(CadastroQuestaoForm questaoForm) {
		this.questao = questaoForm.getQuestao();
		this.dataExpiracao = questaoForm.getDataExpiracao();
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
}
