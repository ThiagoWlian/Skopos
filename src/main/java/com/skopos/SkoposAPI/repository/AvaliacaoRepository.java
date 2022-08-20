package com.skopos.SkoposAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skopos.SkoposAPI.model.AvaliacaoModel;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoModel, Integer>{
}
