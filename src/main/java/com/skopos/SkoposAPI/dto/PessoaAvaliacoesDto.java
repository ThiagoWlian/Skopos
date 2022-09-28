package com.skopos.SkoposAPI.dto;

import java.util.List;

public class PessoaAvaliacoesDto {

    private int id;
    private List<QuestaoOpcaoDto> avaliacoes;

    public PessoaAvaliacoesDto(int id, List<QuestaoOpcaoDto> avaliacoes) {
        this.id = id;
        this.avaliacoes = avaliacoes;
    }

    public PessoaAvaliacoesDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<QuestaoOpcaoDto> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<QuestaoOpcaoDto> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
