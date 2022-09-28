package com.skopos.SkoposAPI.dto.exercicios;

public class ExercicioRetorno {

    private String pontos = "120";
    private String distancia = "60.8";
    private String tempo = "1h52min";

    public String getPontos() {
        return pontos;
    }

    public void setPontos(String pontos) {
        this.pontos = pontos;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }
}
