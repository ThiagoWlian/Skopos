package com.skopos.SkoposAPI.controller.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skopos.SkoposAPI.model.PermissaoModel;
import com.skopos.SkoposAPI.repository.PermissaoRepository;

@Service
public class PermissaoService {
	
	@Autowired
	PermissaoRepository permissaoRepository;
	
	public PermissaoModel cadastraPermissao(PermissaoModel permissaoModel) {
		Optional<PermissaoModel> permissaoResultado = verificaSePermissaoExiste(permissaoModel.getNome());
		
		if(permissaoResultado.isEmpty()) {
			return permissaoRepository.save(permissaoModel);
			
		}
		System.out.println(permissaoResultado.get().getId() + "------------------------------------------------------------------------------------------------------------");
		return permissaoResultado.get();
	}
	
	public Optional<PermissaoModel> verificaSePermissaoExiste(String permissaoNome) {
		Optional<PermissaoModel> permissaoModel = permissaoRepository.getByNome(permissaoNome);
		return permissaoModel;
	}
	
}
