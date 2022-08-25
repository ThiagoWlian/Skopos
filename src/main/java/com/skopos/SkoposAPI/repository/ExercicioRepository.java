package com.skopos.SkoposAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skopos.SkoposAPI.model.ExercicioModel;

public interface ExercicioRepository extends JpaRepository<ExercicioModel, Long>{
	
	@Query("SELECT distance, moving_time FROM ExercicioModel e WHERE e.pessoa.id = ?1")
	public List<ExercicioModel> getMediaAllByPessoaId(int idPessoa);
}
