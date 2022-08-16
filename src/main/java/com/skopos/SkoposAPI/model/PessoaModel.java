package com.skopos.SkoposAPI.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(name = "E-MAIL")
	private String email;
	private String cargo;
	private String telefone;
	@OneToOne
	private EnderecoModel endereco;
	@Column(name = "pontos_respostas")
	private long pontos;
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
	
	public PessoaModel(String nome, String sobrenome, Date nascimento, String cargo, String email, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nascimento = nascimento;
		this.cargo = cargo;
		this.email = email;
		this.telefone = email;
	}
	
	public void aumentarNumeroDePontos(int numeroPontos) {
		this.pontos += numeroPontos;
	}
	
	public long getPontos() {
		return pontos;
	}

	public void setPontos(long pontos) {
		this.pontos = pontos;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
