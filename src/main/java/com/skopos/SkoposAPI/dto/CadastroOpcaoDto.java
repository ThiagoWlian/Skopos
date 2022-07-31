package com.skopos.SkoposAPI.dto;

import com.skopos.SkoposAPI.model.OpcaoModel;

public class CadastroOpcaoDto {
	private String nome;
	private String imagemCaminho;
	
	public CadastroOpcaoDto(OpcaoModel opcaoModel) {
		this.nome = opcaoModel.getNome();
		this.imagemCaminho = opcaoModel.getImagemCaminho();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImagemCaminho() {
		return imagemCaminho;
	}
	public void setImagemCaminho(String imagemCaminho) {
		this.imagemCaminho = imagemCaminho;
	}
}
