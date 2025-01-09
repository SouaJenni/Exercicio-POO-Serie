/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expooserie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jenni
 */
public class Serie {
    int nota;
    String tituloSerie;
    private List<Temporada> temporadas;

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
        
        String serie = this.tituloSerie + " - " + (this.temporadas.size()+1) + " temporadas" + " - " + "Nota: " + notaSerie + "\n";
        return serie;
    }
    
}
