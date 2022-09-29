package com.skopos.SkoposAPI.repository;

import java.util.List;

import com.skopos.SkoposAPI.dto.exercicios.ExercicioDto;
import com.skopos.SkoposAPI.dto.exercicios.ExercicioRetorno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skopos.SkoposAPI.model.ExercicioModel;

public interface ExercicioRepository extends JpaRepository<ExercicioModel, Long>{
	@Query("SELECT new com.skopos.SkoposAPI.dto.exercicios.ExercicioRetorno(SUM(e.distance), SUM(e.moving_time)) FROM ExercicioModel e")
	public ExercicioRetorno getMediaAllByPessoaId(int idPessoa);
}
