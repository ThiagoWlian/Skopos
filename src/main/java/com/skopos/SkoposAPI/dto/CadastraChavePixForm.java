package com.skopos.SkoposAPI.dto;

import com.skopos.SkoposAPI.model.ChavePixModel;
import com.skopos.SkoposAPI.model.PessoaModel;

public class CadastraChavePixForm {
	private String chave;
	private int idPessoa;
	
	public ChavePixModel converteParaChavePixModel() {
		return new ChavePixModel(chave);
	}
	
	public PessoaModel converteParaPessoaModel() {
		return new PessoaModel(idPessoa);
	}
	
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	
}
