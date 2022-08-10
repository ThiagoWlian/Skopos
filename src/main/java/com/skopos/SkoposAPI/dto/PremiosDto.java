package com.skopos.SkoposAPI.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.skopos.SkoposAPI.model.PremioModel;

public class PremiosDto {
	private String nome;
	private String descricao;
	private String imagemCaminho;
	private int quantidadeDisponivel;
	
	public PremiosDto(PremioModel premio) {
		this.nome = premio.getNome();
		this.descricao = premio.getDescricao();
		this.imagemCaminho = premio.getImagemCaminho();
		this.quantidadeDisponivel = premio.getQuantidadeDisponivel();
	}
	
	
	public PremiosDto(String nome, String descricao, String imagemCaminho, int quantidadeDisponivel, String cnpj) {
		this.nome = nome;
		this.descricao = descricao;
		this.imagemCaminho = imagemCaminho;
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public PremiosDto() {
		// TODO Auto-generated constructor stub
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
	
	public List<PremiosDto> converter(List<PremioModel> listaPremios){
		return listaPremios.stream().map(PremiosDto::new).collect(Collectors.toList());
	}
}
