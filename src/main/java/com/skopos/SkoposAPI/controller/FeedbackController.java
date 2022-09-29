package com.skopos.SkoposAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skopos.SkoposAPI.controller.service.FeedbackService;
import com.skopos.SkoposAPI.dto.FeedbackDto;
import com.skopos.SkoposAPI.model.FeedbackModel;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping
	public ResponseEntity<?> enviarFeedback(@RequestBody @Valid FeedbackDto feedbackDto){
		FeedbackModel feedback = new FeedbackModel();
		feedback.setFeedback(feedbackDto.getFeedback());
		return feedbackService.criaFeedback(feedback,feedbackDto.getIdEmpresa(), feedbackDto.getIdPessoa());
	}
	
	@GetMapping
	public ResponseEntity<?> buscarTodosFeedbacks(){
		return feedbackService.buscaFeedback();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarTodosFeedbacksPorEmpresa(@PathVariable int id){
		return feedbackService.buscaFeedback();
	}
}
