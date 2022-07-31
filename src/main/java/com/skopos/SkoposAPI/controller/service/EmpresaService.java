package com.skopos.SkoposAPI.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skopos.SkoposAPI.model.EmpresaModel;
import com.skopos.SkoposAPI.model.EnderecoModel;
import com.skopos.SkoposAPI.model.UsuarioModel;
import com.skopos.SkoposAPI.repository.EmpresaRepository;
import com.skopos.SkoposAPI.repository.EnderecoRepository;
import com.skopos.SkoposAPI.repository.UsuarioRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public void cadastraEmpresa(EnderecoModel endereco, EmpresaModel empresa) {
		enderecoRepository.save(endereco);
		empresa.setEndereco(endereco);
		empresaRepository.save(empresa);
	}
}
