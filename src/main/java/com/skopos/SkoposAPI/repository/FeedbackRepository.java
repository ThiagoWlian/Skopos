package com.skopos.SkoposAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skopos.SkoposAPI.model.FeedbackModel;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackModel, Integer>{

}
