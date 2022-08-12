package com.skopos.SkoposAPI.dto;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.skopos.SkoposAPI.model.EmpresaModel;
import com.skopos.SkoposAPI.model.PessoaModel;


public class PessoaDto {
	private String nomePessoa;
	private String sobrenome;
	private Date nascimento;
	private String nomeUsuario;
	private String permissao;
	private String rua;
	private int numero;
	private String cidade;
	private String estado;
	private String pais;
	private String cnpj;
	
	
	
	public PessoaDto(PessoaModel pessoa) {
		this.nomePessoa = pessoa.getNome();
		this.sobrenome = pessoa.getSobrenome();
		this.nascimento = pessoa.getNascimento();
		this.nomeUsuario = pessoa.getUsuario().getUsername();
		this.permissao = pessoa.getUsuario().getPerfis().get(0).getNome();
		this.rua = pessoa.getEndereco().getRua();
		this.numero = pessoa.getEndereco().getNumero();
		this.cidade = pessoa.getEndereco().getCidade();
		this.estado = pessoa.getEndereco().getEstado();
		this.pais = pessoa.getEndereco().getPais();
		this.cnpj = pessoa.getEmpresa().getCnpj();
	}
	public PessoaDto() {}
	
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getPermissao() {
		return permissao;
	}
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
	public List<PessoaDto> converteParaList(List<PessoaModel> lista){
		return lista.stream().map(PessoaDto::new).collect(Collectors.toList());
	}

	
}
