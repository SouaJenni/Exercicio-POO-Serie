/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expooserie.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jenni
 */
public class Serie {
    private int nota;
    private String tituloSerie;
    private List<Temporada> temporadas;

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public Serie() {
        temporadas = new ArrayList();
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getTituloSerie() {
        return tituloSerie;
    }

    public void setTituloSerie(String tituloSerie) {
        this.tituloSerie = tituloSerie;
    }

    public void adicionarTemporada(Temporada temporada) {
        temporadas.add(temporada);
    }

    @Override
    public String toString() {
        int quantidade = 0;
        int somaAvaliacoes = 0;
        for(Temporada temporada : this.temporadas){
            for(Episodio episodio : temporada.getEpisodios()){
                somaAvaliacoes = somaAvaliacoes + episodio.getAvaliacao();
                    quantidade ++;
            }
        }
        float notaSerie = (float) somaAvaliacoes / quantidade;
        
        String serie = this.tituloSerie + " - " + temporadas.size() + " temporadas" + " - " + "Nota: " + notaSerie + "\n";

        for(Temporada temporada : temporadas){
            serie += temporada.toString()+"\n";
        }
        return serie;
    }
    
}
