package com.skopos.SkoposAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skopos.SkoposAPI.model.PessoaModel;

public interface PessoaRepositoy extends JpaRepository<PessoaModel, Integer>{
	
	@Query("Select pontos from PessoaModel Where id = ?1")
	public long findPontosById(int id);

}
