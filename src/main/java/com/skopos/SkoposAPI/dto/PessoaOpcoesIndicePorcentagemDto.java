package com.skopos.SkoposAPI.dto;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaOpcoesIndicePorcentagemDto {

    private int id;
    private String pessimo;
    private String ruim;
    private String regular;
    private String bom;
    private String otimo;


    public PessoaOpcoesIndicePorcentagemDto() {}
    public PessoaOpcoesIndicePorcentagemDto(PessoaOpcoesIndexDto dto) {
        this.id = dto.getId();
        this.pessimo = String.format("%.0f", ((double)dto.getPessimo()/dto.getTotal())*100) + "%";
        this.ruim = String.format("%.0f", ((double)dto.getRuim()/dto.getTotal())*100) + "%";
        this.regular = String.format("%.0f", ((double)dto.getRegular()/dto.getTotal())*100) + "%";
        this.bom = String.format("%.0f", ((double)dto.getBom()/dto.getTotal())*100) + "%";
        this.otimo = String.format("%.0f", ((double)dto.getOtimo()/dto.getTotal())*100) + "%";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPessimo() {
        return pessimo;
    }

    public void setPessimo(String pessimo) {
        this.pessimo = pessimo;
    }

    public String getRuim() {
        return ruim;
    }

    public void setRuim(String ruim) {
        this.ruim = ruim;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getBom() {
        return bom;
    }

    public void setBom(String bom) {
        this.bom = bom;
    }

    public String getOtimo() {
        return otimo;
    }

    public void setOtimo(String otimo) {
        this.otimo = otimo;
    }

    public List<PessoaOpcoesIndicePorcentagemDto> converter(List<PessoaOpcoesIndexDto> lista) {
        return lista.stream().map(PessoaOpcoesIndicePorcentagemDto::new).collect(Collectors.toList());
    }
}
