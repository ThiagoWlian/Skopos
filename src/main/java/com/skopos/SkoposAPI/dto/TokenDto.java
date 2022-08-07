package com.skopos.SkoposAPI.dto;

import javax.validation.constraints.NotBlank;

public class TokenDto {
	
	@NotBlank
	private String token;
	@NotBlank
	private String tipo;
	@NotBlank
	private String tipoUsuario;

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public TokenDto(String token, String tipo, String permissao) {
		this.token = token;
		this.tipo = tipo;
		this.tipoUsuario = permissao;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}

