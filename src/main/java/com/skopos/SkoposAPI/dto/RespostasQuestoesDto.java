package com.skopos.SkoposAPI.dto;

import java.util.List;

public class RespostasQuestoesDto {
	private String nomeQuestao;
	private List<DadosOpcaoQuestaoDto> opcoes;
	
	public RespostasQuestoesDto(String nomeQuestao, List<DadosOpcaoQuestaoDto> opcoes) {
		this.nomeQuestao = nomeQuestao;
		this.opcoes = opcoes;
	}

	public String getNomeQuestao() {
		return nomeQuestao;
	}
	
	public void setNomeQuestao(String nomeQuestao) {
		this.nomeQuestao = nomeQuestao;
	}
	
	public List<DadosOpcaoQuestaoDto> getOpcoes() {
		return opcoes;
	}
	
	public void setOpcoes(List<DadosOpcaoQuestaoDto> opcoes) {
		this.opcoes = opcoes;
	}
	
	public void addOpcoes(DadosOpcaoQuestaoDto opcao) {
		this.opcoes.add(opcao);
	}
}
