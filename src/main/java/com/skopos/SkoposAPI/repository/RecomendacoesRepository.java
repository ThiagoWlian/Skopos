package com.skopos.SkoposAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skopos.SkoposAPI.model.RecomendacoesModel;

public interface RecomendacoesRepository extends JpaRepository<RecomendacoesModel, Integer>{

	Optional<RecomendacoesModel> findByPessoaId(int pessoaId);

}
