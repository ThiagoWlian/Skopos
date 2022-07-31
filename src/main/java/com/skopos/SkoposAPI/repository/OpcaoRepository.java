package com.skopos.SkoposAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skopos.SkoposAPI.model.OpcaoModel;

public interface OpcaoRepository extends JpaRepository<OpcaoModel, Integer>{
	
}
