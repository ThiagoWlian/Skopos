package com.skopos.SkoposAPI.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class PessoaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String sobrenome;
	private Date nascimento;
	@OneToOne
	private EnderecoModel endereco;
	@OneToOne
	private UsuarioModel usuario;
	@ManyToOne
	private EmpresaModel empresa;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
	private List<ChavePixModel> chaves;
	@ManyToMany(mappedBy = "pessoas")
	private List<PremioModel> premios;
	
	public PessoaModel() {}
	
	public PessoaModel(int id) {
		this.id = id;
	}
	
	public PessoaModel(String nome, String sobrenome, Date nascimento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nascimento = nascimento;
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
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public EnderecoModel getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoModel endereco) {
		this.endereco = endereco;
	}
	public UsuarioModel getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	public EmpresaModel getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaModel empresa) {
		this.empresa = empresa;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
}
