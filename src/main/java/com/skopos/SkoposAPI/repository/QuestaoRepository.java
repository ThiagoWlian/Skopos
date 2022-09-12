package com.skopos.SkoposAPI.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skopos.SkoposAPI.model.QuestaoModel;

public interface QuestaoRepository extends JpaRepository<QuestaoModel, Integer>{
	
	@Query("SELECT q FROM QuestaoModel q WHERE q.dataExpiracao > ?2 AND empresa.id = ?1")
	public List<QuestaoModel> findByEmpresaStatus(int idEmpresa, Date date);
}
