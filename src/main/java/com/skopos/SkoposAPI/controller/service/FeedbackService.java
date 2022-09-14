package com.skopos.SkoposAPI.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skopos.SkoposAPI.dto.FeedbackDto;
import com.skopos.SkoposAPI.model.EmpresaModel;
import com.skopos.SkoposAPI.model.FeedbackModel;
import com.skopos.SkoposAPI.repository.EmpresaRepository;
import com.skopos.SkoposAPI.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	public ResponseEntity<?> criaFeedback(FeedbackModel feedback, int idEmpresa){
		Optional<EmpresaModel> empresa = empresaRepository.findById(idEmpresa);
		if(empresa.isPresent()) {
			feedback.setEmpresa(empresa.get());
			feedbackRepository.save(feedback);
			return ResponseEntity.created(null).build();
		}
		return ResponseEntity.badRequest().body("ID da empresa inexistente!");
	}
	
	public ResponseEntity<?> buscaFeedbackByEmpresa(int id){
		List<FeedbackModel> feedbackList = feedbackRepository.findByEmpresaId(id);
		if(feedbackList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(new FeedbackDto().converteListaFeedbackModel(feedbackList));
	}
	
	public ResponseEntity<?> buscaFeedback(){
		List<FeedbackModel> feedbackList = feedbackRepository.findAll();
		if(feedbackList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(new FeedbackDto().converteListaFeedbackModel(feedbackList));
	}
}
