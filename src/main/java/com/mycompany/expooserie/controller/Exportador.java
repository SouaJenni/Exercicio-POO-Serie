package com.mycompany.expooserie.controller;

import com.mycompany.expooserie.model.Episodio;
import com.mycompany.expooserie.model.Serie;
import com.mycompany.expooserie.model.Temporada;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Exportador {
    public void salvarArquivo(String caminho, List<Serie> series){
        String dados = "";
        int i = 0;
        for(Serie serie: series){
            for(Temporada temporada: serie.getTemporadas()){
                for(Episodio episodio: temporada.getEpisodios()){
                    dados += episodio.getTitulo() + ";" + episodio.getComentario() + ";" + episodio.getAvaliacao() + ";" + episodio.getDuracao() + "\n";
                }
                dados += "---\n";
                dados += temporada.getDescricao() + "\n";
                dados += "---\n";
            }
            dados += "---\n";
            dados += serie.getTituloSerie() + ";" + serie.getNota();
            i++;
            if(i != series.size()){
             dados += "\n";
            }
        }
        File arquivo = new File(caminho);
        if(!arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.err.println("Erro ao criar arquivo");
            }
        }
        try {
            FileWriter escritor = new FileWriter(caminho);
            escritor.write(dados);
            escritor.close();
        } catch (IOException e) {
           System.err.println("Erro ao escrever arquivo");
        }
    }

}
