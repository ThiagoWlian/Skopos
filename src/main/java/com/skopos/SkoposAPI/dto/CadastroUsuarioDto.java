package com.skopos.SkoposAPI.dto;

import com.skopos.SkoposAPI.model.UsuarioModel;

public class CadastroUsuarioDto {
	String nome;
	String senha;
	
	public CadastroUsuarioDto(UsuarioModel usuario) {
		this.nome = usuario.getUsername();
		this.senha = usuario.getPassword();
	}
	
	public CadastroUsuarioDto(CadastroUsuarioForm usuario) {
		this.nome = usuario.getNome();
		this.senha = usuario.getSenha();
	}

	public UsuarioModel converterParaUsuario(){
		return new UsuarioModel(this.nome,this.senha);
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
