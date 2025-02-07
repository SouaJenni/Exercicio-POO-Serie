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
public class Temporada {
    private String descricao;
    private int numeroTp;
    private List<Episodio> episodios;

    public Temporada() {
        episodios = new ArrayList();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroTp() {
        return numeroTp;
    }

    public void setNumeroTp(int numeroTp) {
        this.numeroTp = numeroTp;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        String resultado = "TEMPORADA: " + this.numeroTp + "\n";
        resultado += "Resumo: " + this.descricao + "\n";
        resultado += "\nEpisódios:\n";        
        for (Episodio episodio : episodios) {
            resultado += episodio.toString() + "\n";
        }
        return resultado; 
    }

    
}
