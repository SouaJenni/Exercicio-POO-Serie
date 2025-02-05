package com.mycompany.expooserie.controller;

import com.mycompany.expooserie.model.Episodio;
import com.mycompany.expooserie.model.Serie;
import com.mycompany.expooserie.model.Temporada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImportadorDB {
    public List<Serie> leitorBancoDeDados(){
        Connection connection;
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASS");
        String url = "jdbc:mysql://localhost:3306/mydb";
        try{
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from serie");
            List<Serie> series = new ArrayList<>();
            while (resultSet.next()) {
                Serie serie = new Serie();
                serie.setNota(resultSet.getInt("nota"));
                serie.setTituloSerie(resultSet.getString("tituloSerie"));
                int idSerie = resultSet.getInt("id");
                Statement statementTemporada = connection.createStatement();
                ResultSet temporadasResult = statementTemporada.executeQuery("select * from temporada where Serie_id="+idSerie);
                List<Temporada> temporadas = new ArrayList<>();
                while (temporadasResult.next()) {
                    Temporada temporada = new Temporada();
                    temporada.setDescricao(temporadasResult.getString("descricao"));
                    temporada.setNumeroTp(temporadasResult.getInt("numeroTp"));
                    int idTemporada = temporadasResult.getInt("id");
                    Statement statementEpisodio = connection.createStatement();
                    ResultSet episodiosResult = statementEpisodio.executeQuery("select * from episodio where Temporada_id="+idTemporada);
                    List<Episodio> episodios = new ArrayList<>();
                    while (episodiosResult.next()) {
                        Episodio episodio = new Episodio();
                        episodio.setTitulo(episodiosResult.getString("titulo"));
                        episodio.setDuracao(episodiosResult.getInt("duracao"));
                        episodio.setComentario(episodiosResult.getString("comentario"));
                        episodio.setAvaliacao(episodiosResult.getInt("avaliacao"));
                        episodio.setNumeroEp(episodiosResult.getInt("numero"));
                        episodios.add(episodio);
                    }
                    episodiosResult.close();
                    temporada.setEpisodios(episodios);
                    temporadas.add(temporada);
                }
                temporadasResult.close();
                serie.setTemporadas(temporadas);
                series.add(serie);
            }
            resultSet.close();
            return series;
        }catch (Exception e){
            new Utils().mostrarErro(e.getMessage());
            return null;
        }
    }
}
