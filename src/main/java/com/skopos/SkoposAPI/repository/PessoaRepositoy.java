package com.skopos.SkoposAPI.repository;

import com.skopos.SkoposAPI.dto.PessoaOpcoesIndexDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skopos.SkoposAPI.model.PessoaModel;

import java.util.List;

public interface PessoaRepositoy extends JpaRepository<PessoaModel, Integer>{
	
	@Query("Select pontos from PessoaModel Where id = ?1")
	public long findPontosById(int id);
	
	@Query("Select pai from PessoaModel Where id = ?1")
	public long findPaiById(int id);
	@Query("SELECT new com.skopos.SkoposAPI.dto.PessoaOpcoesIndexDto(am.pessoa.id ," +
			"(SELECT COUNT(O.tipo) FROM AvaliacaoModel A JOIN OpcaoModel O ON O.id = A.opcao.id  WHERE A.pessoa.id = am.pessoa.id AND O.tipo = 'pessimo')," +
			"(SELECT COUNT(O.tipo) FROM AvaliacaoModel A JOIN OpcaoModel O ON O.id = A.opcao.id   WHERE A.pessoa.id = am.pessoa.id AND O.tipo = 'ruim') ," +
			"(SELECT COUNT(O.tipo) FROM AvaliacaoModel A JOIN OpcaoModel O ON O.id = A.opcao.id   WHERE A.pessoa.id = am.pessoa.id AND O.tipo = 'regular')," +
			"(SELECT COUNT(O.tipo) FROM AvaliacaoModel A JOIN OpcaoModel O ON O.id = A.opcao.id   WHERE A.pessoa.id = am.pessoa.id AND O.tipo = 'bom')," +
			"(SELECT COUNT(O.tipo) FROM AvaliacaoModel A JOIN OpcaoModel O ON O.id = A.opcao.id   WHERE A.pessoa.id = am.pessoa.id AND O.tipo = 'otimo')," +
			"am.pessoa.empresa.nome) " +
			"FROM AvaliacaoModel am GROUP BY am.pessoa.id")
	public List<PessoaOpcoesIndexDto> findIndiceOpcoes();

}
