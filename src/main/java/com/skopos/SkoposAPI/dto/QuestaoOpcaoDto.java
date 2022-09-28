package com.skopos.SkoposAPI.dto;

import com.skopos.SkoposAPI.model.AvaliacaoModel;

import java.util.ArrayList;
import java.util.List;

public class QuestaoOpcaoDto {

    private String questao;
    private String opcao;

    public QuestaoOpcaoDto(String questao, String opcao) {
        this.questao = questao;
        this.opcao = opcao;
    }

    public QuestaoOpcaoDto() {

    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public List<QuestaoOpcaoDto> converteAvaliacaoModelEmDto(List<AvaliacaoModel> avaliacoes) {
        List<QuestaoOpcaoDto> listaOpcoes = new ArrayList<>();
        for (AvaliacaoModel avaliacaoModel : avaliacoes) {
            listaOpcoes.add(new QuestaoOpcaoDto(avaliacaoModel.getQuestao().getQuestao(), avaliacaoModel.getOpcao().getNome()));
        }
        return  listaOpcoes;
    }
}
