package com.skopos.SkoposAPI.dto;

public class CadastroPremioDto {
	private String nome;
	private String descricao;
	private String imagemCaminho;
	private int quantidadeDisponivel;
	private float valor;
	private int id;
	
	public CadastroPremioDto(CadastroPremioForm premioForm) {
		this.nome = premioForm.getNome();
		this.descricao = premioForm.getDescricao();
		this.imagemCaminho = premioForm.getImagemCaminho();
		this.quantidadeDisponivel = premioForm.getQuantidadeDisponivel();
		this.id = premioForm.getId();
		this.valor = premioForm.getValor();
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
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
}
