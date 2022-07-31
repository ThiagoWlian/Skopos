package com.skopos.SkoposAPI.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.skopos.SkoposAPI.model.PremioModel;

public class CadastroPremioForm {
	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	@NotBlank
	private String imagemCaminho;
	@NotNull
	private int quantidadeDisponivel;
	@NotBlank
	private String cnpj;
	
	public PremioModel converteParaPremioModel() {
		return new PremioModel(nome,descricao,imagemCaminho,quantidadeDisponivel);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImagemCaminho() {
		return imagemCaminho;
	}
	public void setImagemCaminho(String imagemCaminho) {
		this.imagemCaminho = imagemCaminho;
	}
	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}
	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
