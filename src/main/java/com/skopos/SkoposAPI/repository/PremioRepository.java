package com.skopos.SkoposAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skopos.SkoposAPI.model.PremioModel;

public interface PremioRepository extends JpaRepository<PremioModel, Integer>{
	
	@Query("Select p From PremioModel p Join p.pessoas pe Where pe.id = ?1")
	public List<PremioModel> findPremiosEnviadosPorUsuarioId(int Id);
}
