package com.skopos.SkoposAPI.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skopos.SkoposAPI.model.FeedbackModel;
import com.skopos.SkoposAPI.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	public ResponseEntity<?> criaFeedback(FeedbackModel feedback){
		feedbackRepository.save(feedback);
		return ResponseEntity.created(null).build();
	}
	
	public ResponseEntity<?> buscaFeedback(){
		List<FeedbackModel> feedbackList = feedbackRepository.findAll();
		if(feedbackList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(feedbackList);
	}
}
