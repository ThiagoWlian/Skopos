package com.skopos.SkoposAPI.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OPCAO")
public class OpcaoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@Column(name = "IMAGEM_CAMINHO")
	private String imagemCaminho;

	private String tipo;
	@ManyToOne
	private QuestaoModel questao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opcao")
    private List<AvaliacaoModel> avaliacao;
    
    public OpcaoModel() {}
    
	public OpcaoModel(String nome, String imagemCaminho) {
		this.nome = nome;
		this.imagemCaminho = imagemCaminho;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImagemCaminho() {
		return imagemCaminho;
	}
	public void setImagemCaminho(String imagemCaminho) {
		this.imagemCaminho = imagemCaminho;
	}
	public QuestaoModel getQuestao() {
		return questao;
	}
	public void setQuestao(QuestaoModel questao) {
		this.questao = questao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<AvaliacaoModel> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(List<AvaliacaoModel> avaliacao) {
		this.avaliacao = avaliacao;
	}
}
