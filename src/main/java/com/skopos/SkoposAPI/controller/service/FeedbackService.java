package com.skopos.SkoposAPI.controller.service;

import java.util.List;
import java.util.Optional;

import com.skopos.SkoposAPI.model.PessoaModel;
import com.skopos.SkoposAPI.repository.PessoaRepositoy;
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

	@Autowired
	PessoaRepositoy pessoaRepositoy;
	
	public ResponseEntity<?> criaFeedback(FeedbackModel feedback, int idEmpresa, int idPessoa){
		Optional<EmpresaModel> empresa = empresaRepository.findById(idEmpresa);
		Optional<PessoaModel> pessoa = pessoaRepositoy.findById(idPessoa);
		if(empresa.isPresent()) {
			feedback.setEmpresa(empresa.get());
			feedback.setPessoa(pessoa.get());
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
