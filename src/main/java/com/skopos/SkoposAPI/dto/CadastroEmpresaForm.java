package com.skopos.SkoposAPI.dto;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.skopos.SkoposAPI.model.EmpresaModel;
import com.skopos.SkoposAPI.model.EnderecoModel;
import com.skopos.SkoposAPI.model.UsuarioModel;

public class CadastroEmpresaForm {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String cnpj;
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
	
	public CadastroEmpresaForm() {}
	
	public CadastroEmpresaForm(EmpresaModel empresa, EnderecoModel endereco) {
		this.nome = empresa.getNome();
		this.cnpj = empresa.getCnpj();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.pais = endereco.getPais();
	}

	public EmpresaModel converterParaEmpresa(){
		return new EmpresaModel(this.nome, this.cnpj);
	}
	
	public EnderecoModel converterParaEndereco(){
		return new EnderecoModel(this.rua, this.numero, this.cidade, this.estado,this.pais);
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
	
	
}
