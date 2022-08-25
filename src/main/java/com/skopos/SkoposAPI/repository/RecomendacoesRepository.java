package com.skopos.SkoposAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skopos.SkoposAPI.model.RecomendacoesModel;

public interface RecomendacoesRepository extends JpaRepository<RecomendacoesModel, Integer>{

	@Query("SELECT * FROM RECOMENDACOES WHERE PESSOA_ID = :1")
	Optional<RecomendacoesModel> findByPessoaId(int pessoaId);

}
