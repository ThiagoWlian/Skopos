package com.skopos.SkoposAPI.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@ManyToMany
	@JoinTable(name = "RESGATE_PREMIO",
	joinColumns = @JoinColumn(name = "PREMIO_ID"),
	inverseJoinColumns = @JoinColumn(name = "PESSOA_ID")
	)
	private List<PessoaModel> pessoas;
	
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
	
	public List<PessoaModel> getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(PessoaModel pessoa) {
		pessoas.add(pessoa);
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
