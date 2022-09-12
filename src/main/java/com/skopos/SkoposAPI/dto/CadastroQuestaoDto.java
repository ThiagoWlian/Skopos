package com.skopos.SkoposAPI.dto;

import java.sql.Date;

public class CadastroQuestaoDto {
	private String questao;
	private Date dataExpiracao;
	private int idQuestao;
	
	public CadastroQuestaoDto(CadastroQuestaoForm questaoForm, int idQuestao) {
		this.questao = questaoForm.getQuestao();
		this.dataExpiracao = questaoForm.getDataExpiracao();
		this.idQuestao = idQuestao;
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

	public int getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}
	
	
}
