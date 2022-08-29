package com.skopos.SkoposAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skopos.SkoposAPI.model.RecomendacoesModel;

public interface RecomendacoesRepository extends JpaRepository<RecomendacoesModel, Integer>{

	List<RecomendacoesModel> findByPessoaId(int pessoaId);

}
