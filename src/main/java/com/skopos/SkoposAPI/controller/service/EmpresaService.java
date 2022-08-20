package com.skopos.SkoposAPI.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skopos.SkoposAPI.dto.EmpresaDto;
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
	
	public ResponseEntity buscaTodasEmpresas() {
		List<EmpresaModel> listaEmpresas = empresaRepository.findAll();
		if(listaEmpresas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(new EmpresaDto().converteParaList(listaEmpresas));
	}
	
	public ResponseEntity buscaEmpresaPorId(int idEmpresa) {
		Optional<EmpresaModel> empresa = empresaRepository.findById(idEmpresa);
		if(empresa.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(new EmpresaDto(empresa.get()));
	}
	
	public ResponseEntity buscaEmpresaPorCnpj(String cnpj) {
		EmpresaModel empresa = empresaRepository.findByCnpj(cnpj);
		if(empresa == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(new EmpresaDto(empresa));
	}
	
	public ResponseEntity<?> removerEmpresa(int idEmpresa){
		try {
			empresaRepository.deleteById(idEmpresa);
			return ResponseEntity.ok().build();
		}
		catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
