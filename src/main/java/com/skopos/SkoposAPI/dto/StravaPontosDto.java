package com.skopos.SkoposAPI.dto;

public class StravaPontosDto {
    private int pontosGerados;

    public int getPontosGerados() {
        return pontosGerados;
    }

    public void setPontosGerados(int pontosGerados) {
        this.pontosGerados = pontosGerados;
    }

    public StravaPontosDto(int pontosGerados) {
        this.pontosGerados = pontosGerados;
    }
}
