package com.skopos.SkoposAPI.dto;

public class PaiDto {
    private long pontuacaoPai;

    public PaiDto(long pontuacaoPai) {
        this.pontuacaoPai = pontuacaoPai;
    }

    public long getPontuacaoPai() {
        return pontuacaoPai;
    }

    public void setPontuacaoPai(long pontuacaoPai) {
        this.pontuacaoPai = pontuacaoPai;
    }
}
