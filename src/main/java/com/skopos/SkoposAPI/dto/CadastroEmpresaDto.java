package com.skopos.SkoposAPI.dto;


import com.skopos.SkoposAPI.model.EmpresaModel;
import com.skopos.SkoposAPI.model.EnderecoModel;
import com.skopos.SkoposAPI.model.UsuarioModel;

public class CadastroEmpresaDto {
	
	private String nome;
	private String cnpj;
	private String email;
	private String telefone;
	private String rua;
	private int numero;
	private String cidade;
	private String estado;
	private String pais;
	
	public CadastroEmpresaDto(EmpresaModel empresa) {
		this.nome = empresa.getNome();
		this.cnpj = empresa.getCnpj();
		this.email = empresa.getEmail();
		this.telefone = empresa.getTelefone();
		this.rua = empresa.getEndereco().getRua();
		this.numero = empresa.getEndereco().getNumero();
		this.cidade = empresa.getEndereco().getCidade();
		this.estado = empresa.getEndereco().getEstado();
		this.pais = empresa.getEndereco().getPais();
	}
	
	public CadastroEmpresaDto(CadastroEmpresaForm empresa) {
		this.nome = empresa.getNome();
		this.cnpj = empresa.getCnpj();
		this.rua = empresa.getRua();
		this.numero = empresa.getNumero();
		this.cidade = empresa.getCidade();
		this.estado = empresa.getEstado();
		this.pais = empresa.getPais();
	}
	
	public CadastroEmpresaDto(EmpresaModel empresa, EnderecoModel endereco) {
		this.nome = empresa.getNome();
		this.cnpj = empresa.getCnpj();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.pais = endereco.getPais();
	}

	public UsuarioModel converterParaUsuario(){
		return new UsuarioModel(this.nome,this.cnpj);
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
