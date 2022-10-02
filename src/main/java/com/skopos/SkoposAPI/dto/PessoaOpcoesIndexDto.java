package com.skopos.SkoposAPI.dto;

public class PessoaOpcoesIndexDto {
    private int id;
    private long pessimo;
    private long ruim;
    private long regular;
    private long bom;
    private long otimo;
    private String empresa;

    public PessoaOpcoesIndexDto(int id, long pessimo, long ruim, long regular, long bom, long otimo, String empresa) {
        this.id = id;
        this.pessimo = pessimo;
        this.ruim = ruim;
        this.regular = regular;
        this.bom = bom;
        this.otimo = otimo;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPessimo() {
        return pessimo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setPessimo(long pessimo) {
        this.pessimo = pessimo;
    }

    public long getRuim() {
        return ruim;
    }

    public void setRuim(long ruim) {
        this.ruim = ruim;
    }

    public long getRegular() {
        return regular;
    }

    public void setRegular(long regular) {
        this.regular = regular;
    }

    public long getBom() {
        return bom;
    }

    public void setBom(long bom) {
        this.bom = bom;
    }

    public long getOtimo() {
        return otimo;
    }

    public void setOtimo(long otimo) {
        this.otimo = otimo;
    }

    public long getTotal() {
        return this.pessimo + this.ruim + this.regular + this.bom + this.otimo;
    }
}
