package com.skopos.SkoposAPI.repository;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skopos.SkoposAPI.dto.DadosOpcaoQuestaoDto;
import com.skopos.SkoposAPI.dto.QuestaoDto;
import com.skopos.SkoposAPI.model.QuestaoModel;

public interface QuestaoRepository extends JpaRepository<QuestaoModel, Integer>{
	
	@Query("SELECT q FROM QuestaoModel q WHERE q.dataExpiracao > ?2 AND q.empresa.id = ?1")
	public List<QuestaoModel> findByEmpresaStatus(int idEmpresa, Date date);
	
	@Query("SELECT new com.skopos.SkoposAPI.dto.DadosOpcaoQuestaoDto(O.nome, COUNT(A.opcao.id)) from QuestaoModel Q JOIN AvaliacaoModel A ON Q.id = A.questao.id JOIN OpcaoModel O ON O.id = A.opcao.id WHERE Q.id = ?1 GROUP BY O.nome")
	public List<DadosOpcaoQuestaoDto> countOpcoesPorAvaliacao(int idQuestao);
	
	@Query("Select new com.skopos.SkoposAPI.dto.QuestaoDto(q.id, q.questao) from QuestaoModel q where q.empresa.id = ?1 ORDER BY q.id DESC")
	public List<QuestaoDto> findNomeById(int idEmpresa);
}
