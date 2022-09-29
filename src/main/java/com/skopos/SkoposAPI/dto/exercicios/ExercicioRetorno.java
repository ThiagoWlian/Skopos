package com.skopos.SkoposAPI.dto.exercicios;

public class ExercicioRetorno {

    private String pontos;
    private String distancia = "60.8";
    private String tempo = "1h52min";

    public ExercicioRetorno (double distancia, double tempo) {
        this.distancia = String.format("%.1f",(distancia/1000))+"Km";
        String hora = String.format("%.0f",((tempo/60)/60))+"h";
        String minutos = String.format("%.0f",((tempo/60)%60)) + "min";
        this.tempo = hora+minutos;
    }

    public ExercicioRetorno() {

    }

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
