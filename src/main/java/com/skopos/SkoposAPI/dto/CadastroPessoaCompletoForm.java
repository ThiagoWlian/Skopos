package com.skopos.SkoposAPI.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skopos.SkoposAPI.model.ChavePixModel;
import com.skopos.SkoposAPI.model.EmpresaModel;
import com.skopos.SkoposAPI.model.EnderecoModel;
import com.skopos.SkoposAPI.model.PermissaoModel;
import com.skopos.SkoposAPI.model.PessoaModel;
import com.skopos.SkoposAPI.model.UsuarioModel;

public class CadastroPessoaCompletoForm {
	
	@NotBlank
	private String nomePessoa;
	@NotBlank
	private String sobrenome;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date nascimento;
	@NotBlank
	private String rg;
	@NotBlank
	private String cpf;
	@NotNull
	private String email;
	@NotNull
	private String cargo;
	@NotNull
	private String telefone;
	@NotBlank
	private String area;
	@NotBlank
	private String nomeUsuario;
	@NotBlank
	private String senha;
	@NotBlank
	private String permissao;
	@NotBlank
	private String rua;
	@NotNull
	private int numero;
	@NotBlank
	private String cidade;
	@NotBlank
	private String estado;
	@NotBlank
	private String pais;
	@NotBlank
	private String pix;
	@NotNull
	private int id;

	public UsuarioModel converterParaUsuario(){
		return new UsuarioModel(this.nomeUsuario, this.senha);
	}
	
	public PessoaModel converterParaPessoa(){
		return new PessoaModel(this.nomePessoa, this.sobrenome, this.nascimento, this.cargo, this.email, this.telefone, this.rg, this.cpf, this.area);
	}
	
	public EnderecoModel converterParaEndereco(){
		return new EnderecoModel(this.rua, this.numero, this.cidade, this.estado,this.pais);
	}
	
	public ChavePixModel converterParaChavePix() {
		return new ChavePixModel(pix);
	}
	
	public PermissaoModel converterParaPermissao(){
		return new PermissaoModel(this.permissao);
	}
	
	public EmpresaModel converterParaEmpresa(){
		return new EmpresaModel(this.id);
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}

	public void setCnpj(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
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

	public void setId(int id) {
		this.id = id;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPix() {
		return pix;
	}

	public void setPix(String pix) {
		this.pix = pix;
	}
}
