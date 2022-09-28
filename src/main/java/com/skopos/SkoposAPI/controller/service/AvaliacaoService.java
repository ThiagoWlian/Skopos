package com.skopos.SkoposAPI.controller.service;

import java.util.List;
import java.util.Optional;

import com.skopos.SkoposAPI.dto.PessoaAvaliacoesDto;
import com.skopos.SkoposAPI.dto.QuestaoOpcaoDto;
import com.skopos.SkoposAPI.model.PessoaModel;
import com.skopos.SkoposAPI.repository.PessoaRepositoy;
import org.hibernate.loader.entity.NaturalIdEntityJoinWalker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skopos.SkoposAPI.model.AvaliacaoModel;
import com.skopos.SkoposAPI.model.OpcaoModel;
import com.skopos.SkoposAPI.model.QuestaoModel;
import com.skopos.SkoposAPI.repository.AvaliacaoRepository;
import com.skopos.SkoposAPI.repository.OpcaoRepository;
import com.skopos.SkoposAPI.repository.QuestaoRepository;

@Service
public class AvaliacaoService {
	@Autowired
	AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	QuestaoRepository questaoRepository;
	
	@Autowired
	OpcaoRepository opcaoRepository;

	@Autowired
	PessoaRepositoy pessoaRepositoy;
	
	public ResponseEntity<?> cadastraNovaAvaliacao(int idQuestao, int idOpcao, int idPessoa) {
		Optional<QuestaoModel> questao = questaoRepository.findById(idQuestao);
		Optional<OpcaoModel> opcao = opcaoRepository.findById(idOpcao);
		Optional<PessoaModel> pessoa = pessoaRepositoy.findById(idPessoa);
		
		if(opcao.isPresent() && questao.isPresent() && pessoa.isPresent()) {
			avaliacaoRepository.save(new AvaliacaoModel(questao.get(), opcao.get(), pessoa.get()));
			return ResponseEntity.created(null).build();
		}
		return ResponseEntity.badRequest().build();
		
	}

	public ResponseEntity<?> buscarAvaliacoesPelaPessoa(int idPessoa) {
		List<AvaliacaoModel> avaliacoes = avaliacaoRepository.findByPessoaId(idPessoa);
		List<QuestaoOpcaoDto> questoesDto = new QuestaoOpcaoDto().converteAvaliacaoModelEmDto(avaliacoes);
		PessoaAvaliacoesDto pessoaAvaliacoesDto = new PessoaAvaliacoesDto();
		pessoaAvaliacoesDto.setId(avaliacoes.get(0).getId());
		pessoaAvaliacoesDto.setAvaliacoes(questoesDto);

		return ResponseEntity.ok(pessoaAvaliacoesDto);
	}
}
