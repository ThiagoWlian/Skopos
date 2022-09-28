package com.skopos.SkoposAPI.controller.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.skopos.SkoposAPI.dto.PessoaOpcoesIndexDto;
import com.skopos.SkoposAPI.dto.PessoaOpcoesIndicePorcentagemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skopos.SkoposAPI.dto.PessoaDto;
import com.skopos.SkoposAPI.model.ChavePixModel;
import com.skopos.SkoposAPI.model.EmpresaModel;
import com.skopos.SkoposAPI.model.EnderecoModel;
import com.skopos.SkoposAPI.model.PermissaoModel;
import com.skopos.SkoposAPI.model.PessoaModel;
import com.skopos.SkoposAPI.model.UsuarioModel;
import com.skopos.SkoposAPI.repository.EmpresaRepository;
import com.skopos.SkoposAPI.repository.EnderecoRepository;
import com.skopos.SkoposAPI.repository.PessoaRepositoy;
import com.skopos.SkoposAPI.repository.UsuarioRepository;

@Service
public class PessoaService {
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PessoaRepositoy pessoaRepositoy;
	
	@Autowired
	private PermissaoService permissaoService;
	
	@Autowired
	private ChavePixService chavePixService;
	
	@Transactional
	public void cadastraPessoa(EnderecoModel endereco, UsuarioModel usuario, PessoaModel pessoa, PermissaoModel permissaoModel, ChavePixModel chavePix, int id) {
		
		enderecoRepository.save(endereco);
		pessoa.setEndereco(endereco);
		PermissaoModel permissao = permissaoService.cadastraPermissao(permissaoModel);
		UsuarioModel novoUsuario = usuarioRepository.save(usuario);
		novoUsuario.setPerfis(permissao);
		usuarioRepository.save(novoUsuario);
		EmpresaModel empresa = empresaRepository.findById(id).get();
		pessoa.setEmpresa(empresa);
		pessoa.setUsuario(usuario);
		pessoa.setEndereco(endereco);
		PessoaModel pessoaModel = pessoaRepositoy.save(pessoa);
		chavePixService.cadastraChavePix(chavePix, pessoaModel.getId());
	}
	
	public Optional<PessoaModel> buscarPessoaPorId(int idPessoa) {
		return pessoaRepositoy.findById(idPessoa);
	}
	
	public ResponseEntity findPessoaPorId(int idPessoa) {
		Optional<PessoaModel> pessoa = pessoaRepositoy.findById(idPessoa);
		if(pessoa.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new PessoaDto(pessoa.get()));
	}
	
	public ResponseEntity buscarTodasPessoa() {
		List<PessoaModel> listaPessoas = pessoaRepositoy.findAll();
		if(listaPessoas.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new PessoaDto().converteParaList(listaPessoas));
	}
	
	public Long buscaPontosPessoaPorId(int id) {
		return pessoaRepositoy.findPontosById(id);
	}
	
	public Optional<PessoaModel> aumentaNumeroDePontos(int id, int numeroPontos) {
		Optional<PessoaModel> pessoa = pessoaRepositoy.findById(id);
		if(pessoa.isPresent()) {
			pessoa.get().aumentarNumeroDePontos(numeroPontos);
			pessoaRepositoy.save(pessoa.get());
		}
		return pessoa;
	}
	
	public Optional<PessoaModel> aumentaNumeroPAI(int id, int numeroPontos) {
		Optional<PessoaModel> pessoa = pessoaRepositoy.findById(id);
		if(pessoa.isPresent()) {
			pessoa.get().aumentarNumeroPai(numeroPontos);
			pessoaRepositoy.save(pessoa.get());
		}
		return pessoa;
	}
	
	public Long buscaPaiPessoaPorId(int id) {
		return pessoaRepositoy.findPaiById(id);
	}

	public List<PessoaOpcoesIndicePorcentagemDto> buscarPessoaComIndiceOpcoes() {
		return new PessoaOpcoesIndicePorcentagemDto().converter(pessoaRepositoy.findIndiceOpcoes());
	}
}
