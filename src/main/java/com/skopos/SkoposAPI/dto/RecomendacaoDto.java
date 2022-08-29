package com.skopos.SkoposAPI.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.skopos.SkoposAPI.model.PremioModel;
import com.skopos.SkoposAPI.model.RecomendacoesModel;

public class RecomendacaoDto {
	
	@NotBlank
	private String descricao;
	@NotNull
	private int idPessoa;
	
	public RecomendacaoDto() {}
	
	public RecomendacaoDto (RecomendacoesModel recomendacoes) {
		this.descricao = recomendacoes.getDescricao();
		this.idPessoa = recomendacoes.getId();
	}
	
	public RecomendacaoDto(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public RecomendacoesModel converteParaRecomendacaoModel() {
		return new RecomendacoesModel(this.descricao, this.idPessoa);
	}
	
	public List<RecomendacaoDto> converter(List<RecomendacoesModel> listaRecomendacoes){
		return listaRecomendacoes.stream().map(RecomendacaoDto::new).collect(Collectors.toList());
	}
}
