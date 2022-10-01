package com.skopos.SkoposAPI.dto;

import java.util.ArrayList;
import java.util.List;

import com.skopos.SkoposAPI.model.OpcaoModel;
import com.skopos.SkoposAPI.model.QuestaoModel;

public class QuestaoDto {
	private int idQuestao;
	private String Questao;
	private List<OpcaoDto> opcoes;
	
	public QuestaoDto() {}
	
	public QuestaoDto(int idQuestao, String questao, List<OpcaoDto> opcoes) {
		this.idQuestao = idQuestao;
		Questao = questao;
		this.opcoes = opcoes;
	}
	
	public QuestaoDto(int idQuestao, String questao) {
		this.idQuestao = idQuestao;
		Questao = questao;
	}

	public int getIdQuestao() {
		return idQuestao;
	}
	
	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}
	
	public String getQuestao() {
		return Questao;
	}
	
	public void setQuestao(String questao) {
		Questao = questao;
	}
	
	public List<OpcaoDto> getOpcoes() {
		return opcoes;
	}
	
	public void setOpcoes(List<OpcaoDto> opcoes) {
		this.opcoes = opcoes;
	}
	
	public List<QuestaoDto> converteQuestaoModelParaQuestaoDto(List<QuestaoModel> questoesModel) {	
		List<QuestaoDto> questoesDto = new ArrayList<QuestaoDto>();
		
		for(QuestaoModel questaoModel : questoesModel) {
			QuestaoDto questaoDto = new QuestaoDto(questaoModel.getID(), questaoModel.getQuestao());
			List<OpcaoDto> opcoesDtoLista = new ArrayList<OpcaoDto>();
			for (OpcaoModel opcao : questaoModel.getOpcao()) {
				opcoesDtoLista.add(new OpcaoDto(opcao.getId(), opcao.getNome(), opcao.getImagemCaminho(),opcao.getTipo()));
			}
			questaoDto.setOpcoes(opcoesDtoLista);
			questoesDto.add(questaoDto);
		}
		return questoesDto;
	}
	
}
