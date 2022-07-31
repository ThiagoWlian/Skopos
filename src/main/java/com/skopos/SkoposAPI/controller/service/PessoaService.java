package com.skopos.SkoposAPI.controller.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void cadastraPessoa(EnderecoModel endereco, UsuarioModel usuario, PessoaModel pessoa, PermissaoModel permissaoModel , String cnpj) {
		
		enderecoRepository.save(endereco);
		pessoa.setEndereco(endereco);
		PermissaoModel permissao = permissaoService.cadastraPermissao(permissaoModel);
		UsuarioModel novoUsuario = usuarioRepository.save(usuario);
		novoUsuario.setPerfis(permissao);
		System.out.println(novoUsuario.getId() + "    " + novoUsuario.getPerfis().get(0).getId() + "====================================");
		usuarioRepository.save(novoUsuario);
		EmpresaModel empresa = empresaRepository.findByCnpj(cnpj);
		pessoa.setEmpresa(empresa);
		pessoa.setUsuario(usuario);
		pessoa.setEndereco(endereco);
		pessoaRepositoy.save(pessoa);
		
	}
	
	public Optional<PessoaModel> buscarPessoaPorId(int idPessoa) {
		return pessoaRepositoy.findById(idPessoa);
	}
}
