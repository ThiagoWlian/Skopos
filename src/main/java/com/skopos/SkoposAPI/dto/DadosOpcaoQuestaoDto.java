package com.skopos.SkoposAPI.dto;

public class DadosOpcaoQuestaoDto {
	private String nome;
	private long quantidade;
	private String tipo;
	
	public DadosOpcaoQuestaoDto(String nome, long quantidade, String tipo) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
