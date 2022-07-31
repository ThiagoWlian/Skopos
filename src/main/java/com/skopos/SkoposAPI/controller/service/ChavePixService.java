package com.skopos.SkoposAPI.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skopos.SkoposAPI.model.ChavePixModel;
import com.skopos.SkoposAPI.model.PessoaModel;
import com.skopos.SkoposAPI.repository.ChavePixRepository;
import com.skopos.SkoposAPI.repository.PessoaRepositoy;

@Service
public class ChavePixService {
	@Autowired
	private ChavePixRepository chavePixRepository;
	
	@Autowired
	private PessoaRepositoy pessoaRepository;
	
	public void cadastraChavePix(ChavePixModel chavePix, int idPessoa) {
		PessoaModel pessoa = pessoaRepository.findById(idPessoa).get();
		if(pessoa != null) {
			chavePix.setPessoa(pessoa);
			chavePixRepository.save(chavePix);
		}
	}
}
