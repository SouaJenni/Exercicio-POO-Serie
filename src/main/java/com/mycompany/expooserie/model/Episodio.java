package com.mycompany.expooserie.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jenni
 */
public class Episodio {
    int duracao;
    String comentario;
    int avaliacao;
    int numeroEp;
    String titulo;

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getNumeroEp() {
        return numeroEp;
    }

    public void setNumeroEp(int numero) {
        this.numeroEp = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Episódio: " + this.numeroEp + " - " + this.titulo + " - " + this.duracao + "min " + "\n" + "Nota: " + this.avaliacao + "/5" + " - " + this.comentario + "\n";    
    }
    
}

