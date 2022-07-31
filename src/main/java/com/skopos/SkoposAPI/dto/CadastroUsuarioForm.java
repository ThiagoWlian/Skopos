package com.skopos.SkoposAPI.dto;

import javax.validation.constraints.NotBlank;

import com.skopos.SkoposAPI.model.UsuarioModel;
public class CadastroUsuarioForm {
	@NotBlank
	private String nome;
	@NotBlank
	private String senha;
	
	public CadastroUsuarioForm() {}
	
	public CadastroUsuarioForm(UsuarioModel usuario) {
		this.nome = usuario.getUsername();
		this.senha = usuario.getPassword();
	}

	public UsuarioModel converterParaUsuario(){
		return new UsuarioModel(this.nome, this.senha);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
