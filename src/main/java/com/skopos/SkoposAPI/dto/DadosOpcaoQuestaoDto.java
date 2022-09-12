package com.skopos.SkoposAPI.dto;

public class DadosOpcaoQuestaoDto {
	private String nome;
	private int quantidade;
	
	public DadosOpcaoQuestaoDto(String nome, int quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
