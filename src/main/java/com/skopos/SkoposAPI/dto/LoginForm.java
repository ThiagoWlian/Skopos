package com.skopos.SkoposAPI.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.skopos.SkoposAPI.model.UsuarioModel;


public class LoginForm {
	@NotBlank
	private String nome;
	@NotBlank
	private String senha;
	
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
	
	public UsuarioModel converterParaUsuarioModel() {
		return new UsuarioModel(this.nome,this.senha);
	}
	public UsernamePasswordAuthenticationToken converterParaUsernamePasswordAuthenticationToken() {
		return new UsernamePasswordAuthenticationToken(nome, senha);
	}
}
