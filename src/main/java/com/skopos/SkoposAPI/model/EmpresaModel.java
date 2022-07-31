package com.skopos.SkoposAPI.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "EMPRESA")
public class EmpresaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cnpj;
    @OneToOne(cascade=CascadeType.ALL)
	private EnderecoModel endereco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<PessoaModel> pessoas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<PremioModel> premio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<QuestaoModel> questoes;
    
    public EmpresaModel(){}
    
	public EmpresaModel(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}
	public EmpresaModel(String cnpj) {
		this.cnpj = cnpj;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public EnderecoModel getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoModel endereco) {
		this.endereco = endereco;
	}
	
	public List<PessoaModel> getPessoas() {
		return pessoas;
	}
	public void setPessoas(PessoaModel pessoas) {
		this.pessoas.add(pessoas);
	}
	
	
    
    
    
}
