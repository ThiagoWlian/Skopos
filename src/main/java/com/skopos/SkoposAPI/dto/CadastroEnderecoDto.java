package com.skopos.SkoposAPI.dto;

import com.skopos.SkoposAPI.model.EmpresaModel;
import com.skopos.SkoposAPI.model.EnderecoModel;
import com.skopos.SkoposAPI.model.UsuarioModel;

public class CadastroEnderecoDto {
	
	private String rua;
	private int numero;
	private String cidade;
	private String estado;
	private String pais;
	
	public CadastroEnderecoDto(EnderecoModel endereco) {
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.pais = endereco.getPais();	
	}
	
	public CadastroEnderecoDto(CadastroEnderecoForm endereco) {
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.pais = endereco.getPais();	
	}

	public EnderecoModel converterParaEndereco(){
		return new EnderecoModel(this.rua,this.numero,this.cidade,this.estado,this.pais);
	}
}
