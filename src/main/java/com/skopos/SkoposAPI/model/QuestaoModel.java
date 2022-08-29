package com.skopos.SkoposAPI.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "QUESTAO")
public class QuestaoModel {
	@Id
	private int id;
	@Size(min = 5, max = 150)
	private String questao;
	@Column(name = "DATA_EXPIRACAO")
	private Date dataExpiracao;
	@ManyToOne
	private EmpresaModel empresa;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "questao")
    private List<OpcaoModel> opcao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questao")
    private List<AvaliacaoModel> avaliacao;
    
	public QuestaoModel(String questao, Date dataExpiracao) {
		this.questao = questao;
		this.dataExpiracao = dataExpiracao;
	}
	
	public QuestaoModel() {}
	
	public QuestaoModel(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	public void setID(int iD) {
		id = iD;
	}
	public String getQuestao() {
		return questao;
	}
	public void setQuestao(String questao) {
		this.questao = questao;
	}
	public Date getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	public EmpresaModel getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaModel empresa) {
		this.empresa = empresa;
	}
	public List<OpcaoModel> getOpcao() {
		return opcao;
	}
	public void setOpcao(List<OpcaoModel> opcao) {
		this.opcao = opcao;
	}
}
