package com.skopos.SkoposAPI.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESA")
public class EmpresaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cnpj;
	private String email;
	private String telefone;
    @OneToOne(cascade=CascadeType.ALL)
	private EnderecoModel endereco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<PessoaModel> pessoas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<PremioModel> premio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<QuestaoModel> questoes;
    
    public EmpresaModel(){}
    
	public EmpresaModel(String nome, String cnpj, String email, String telefone) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.telefone = email;
	}
	public EmpresaModel(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
