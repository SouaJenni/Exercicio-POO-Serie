package com.mycompany.expooserie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Importador {

    public Importador() {
    }

    public List<Serie> leitorArquivo(String caminho){
        List<Serie> seriesLidas = new ArrayList<>();
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader(caminho));
                String linha = buff.readLine();
            while (linha != null) {
                    int numeroTp = 1;
                Serie serie = new Serie();
                List<Temporada> temporadas = new ArrayList<>();
                while (true) {
                    if (linha.equals("---")) {
                        break;
                    }
                    Temporada temporada = new Temporada();
                    List<Episodio> episodios = new ArrayList<>();
                    int numero = 1;
                    do {
                        if (linha.equals("---")) {
                            break;
                        }
                        Episodio episodio = new Episodio();
                        String[] ep = linha.split(";");
                        episodio.setTitulo(ep[0]);
                        episodio.setComentario(ep[1]);
                        episodio.setAvaliacao(Integer.parseInt(ep[2]));
                        episodio.setDuracao(Integer.parseInt(ep[3]));
                        episodio.setNumeroEp(numero);
                        numero++;
                        episodios.add(episodio);
                        linha = buff.readLine();
                    } while (true);
                    if (linha.equals("---")) {
                        linha = buff.readLine();
                        if (linha.equals("---")) {
                            break;
                        }
                    }
                    temporada.setDescricao(linha);
                    temporada.setEpisodios(episodios);
                    temporada.setNumeroTp(numeroTp);
                    numeroTp++;
                    temporadas.add(temporada);
                    buff.readLine();
                    linha = buff.readLine();

                }
                linha = buff.readLine();
                if(linha != null) {
                    String[] s = linha.split(";");
                    serie.setTituloSerie(s[0]);
                    serie.setNota(Integer.parseInt(s[1]));
                    serie.setTemporadas(temporadas);
                    seriesLidas.add(serie);
                }

                linha = buff.readLine();
            }

        } catch (FileNotFoundException e) {
            System.err.println("Não foi possível ler o arquivo");
        } catch (IOException e) {
            System.err.println("Erro ao ler a linha");
        }
            finally {
                if(buff != null){
                    try {
                        buff.close();
                    } catch (IOException e) {
                        System.err.println("Não pôde fechar o arquivo");
                    }
                }
            }
        return seriesLidas;
    }
}
