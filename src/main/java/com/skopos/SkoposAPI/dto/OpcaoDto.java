package com.skopos.SkoposAPI.dto;

public class OpcaoDto {
	private int idOpcao;
	private String Opcao;
	private String imagem;
	
	public OpcaoDto(int idOpcao, String opcao, String imagem) {
		this.idOpcao = idOpcao;
		Opcao = opcao;
		this.imagem = imagem;
	}

	public int getIdOpcao() {
		return idOpcao;
	}
	
	public void setIdOpcao(int idOpcao) {
		this.idOpcao = idOpcao;
	}
	
	public String getOpcao() {
		return Opcao;
	}
	
	public void setOpcao(String opcao) {
		Opcao = opcao;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}
