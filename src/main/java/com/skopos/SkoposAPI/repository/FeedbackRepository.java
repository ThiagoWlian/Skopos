package com.skopos.SkoposAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skopos.SkoposAPI.model.FeedbackModel;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackModel, Integer>{
	public List<FeedbackModel> findByEmpresaId(int id);
}
