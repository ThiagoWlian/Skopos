package com.skopos.SkoposAPI.dto;

public class PremioListaDto {
    private int id;
    private String nome;
    private String descricao;
    private String imagemCaminho;
    private String status;

    public PremioListaDto(int id, String nome, String descricao, String imagemCaminho, String status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagemCaminho = imagemCaminho;
        this.status = status;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemCaminho() {
        return imagemCaminho;
    }

    public void setImagemCaminho(String imagemCaminho) {
        this.imagemCaminho = imagemCaminho;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
