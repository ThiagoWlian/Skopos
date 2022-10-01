package com.skopos.SkoposAPI.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PREMIO")
public class PremioModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String descricao;
	
	@Column(name = "IMAGEM_CAMINHO")
	private String imagemCaminho;
	
	@Column(name = "QUANTIDADE_DISPONIVEL")
	private int quantidadeDisponivel;

	@Column
	private float valor;
	
	@ManyToOne
	private EmpresaModel empresa;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "premio")
	private List<ResgatePremioModel> resgatePremioModels;
	
	public PremioModel() {}
	
	public PremioModel(String nome, String descricao, String imagemCaminho, int quantidadeDisponivel, float valor) {
		this.nome = nome;
		this.descricao = descricao;
		this.imagemCaminho = imagemCaminho;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public EmpresaModel getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(EmpresaModel empresa) {
		this.empresa = empresa;
	}
	
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
