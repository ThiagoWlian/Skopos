package com.skopos.SkoposAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skopos.SkoposAPI.model.EnderecoModel;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Integer>{
	
}
