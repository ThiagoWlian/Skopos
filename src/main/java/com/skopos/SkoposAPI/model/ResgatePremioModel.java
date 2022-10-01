package com.skopos.SkoposAPI.model;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
@Table(name = "RESGATE_PREMIO")
public class ResgatePremioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private PremioModel premio;

    @ManyToOne
    private PessoaModel pessoa;

    public ResgatePremioModel(PremioModel premio, PessoaModel pessoa, String status) {
        this.premio = premio;
        this.pessoa = pessoa;
        this.status = status;
    }

    public ResgatePremioModel() {

    }

    private String status;

    public void setId(int id) {
        this.id = id;
    }

    public PremioModel getPremio() {
        return premio;
    }

    public void setPremio(PremioModel premio) {
        this.premio = premio;
    }

    public PessoaModel getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModel pessoa) {
        this.pessoa = pessoa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
