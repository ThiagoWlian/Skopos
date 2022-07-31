package com.skopos.SkoposAPI.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.skopos.SkoposAPI.model.OpcaoModel;
import com.skopos.SkoposAPI.model.QuestaoModel;

public class CadastroOpcaoForm {
	@NotBlank
	private String nome;
	@NotBlank
	private String imagemCaminho;
	@NotNull
	private int idQuestao;
	
	public OpcaoModel converteParaOpcaoModel() {
		return new OpcaoModel(nome, imagemCaminho);
	}
	
	public QuestaoModel converteParaQuestao() {
		return new QuestaoModel(idQuestao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagemCaminho() {
		return imagemCaminho;
	}

	public void setImagemCaminho(String imagemCaminho) {
		this.imagemCaminho = imagemCaminho;
	}

	public int getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}
}
