package com.skopos.SkoposAPI.dto;

public class DadosOpcaoQuestaoDto {
	private String nome;
	private long quantidade;
	
	public DadosOpcaoQuestaoDto(String nome, long quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
