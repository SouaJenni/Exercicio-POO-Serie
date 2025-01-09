/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.expooserie;

import java.util.ArrayList;
import java.util.List;


public class ExPooSerie {
    private static Leitura leitura = new Leitura();
    private static  List<Serie> series = new ArrayList();
    private static List<Temporada> temporadas = new ArrayList<>();
    
    public static void main(String[] args) {    
        int opcao = 1;
        do {
             System.out.println("----- MENU -----");
            System.out.println("Opções: ");
            System.out.println("1- Listar Series.");
            System.out.println("2- Buscar uma série.");
            System.out.println("3- Deletar uma série.");
            System.out.println("4- Atualizar uma série.");
            System.out.println("5- Cadastrar Serie.");
            System.out.println("6- Ler arquivo.");
            System.out.println("7- Sair");

            opcao = leitura.lerInteiro("");

            switch (opcao){
                case 1:
                    imprimirSeries();
                    break;
                    
                case 2:
                    escolherSerie();
                    break;
                    
                case 3:
                     deletarSerie();
                    break;
                    
                case 4:
                    atualizarSerie();
                break;
                    
                case 5:
                    cadastrarSerie();
                    break;
                    
                case 6:
                    Importador importador = new Importador();
                    Serie serie = importador.leitorArquivo("/home/jenni/Documentos/Exercicio-POO-Serie/src/main/java/com/mycompany/expooserie/serie.txt");
                    series.add(serie);
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opcao Invalida");
            }
        }while(opcao != 7);
    }
    
    
    public static void imprimirSeries (){
        if (series.isEmpty()) {
        System.out.println("Nenhuma série cadastrada.");
        } else {
            System.out.println("Séries cadastradas:");
            for (Serie s : series) {
                System.out.println(s.toString());
            }
            for (Temporada t : temporadas){
                System.out.println(t.toString());
            }
        }
    }
    
    public static void escolherSerie(){
        String serieEscolhida = leitura.lerString("Qual série gostaria de ver?");
        boolean encontrada = false;
        
        for (Serie s : series) {
            if (s.getTituloSerie().equalsIgnoreCase(serieEscolhida)) {
                System.out.println(s);
                encontrada = true;
                break;
            }
        }
        
        if (!encontrada) {
            System.out.println("Série não encontrada.");
        }
    }
    
    public static void deletarSerie(){
        String serieParaDeletar = leitura.lerString("Qual série gostaria de deletar?");
        boolean encontrada = false;

        for (Serie s : series) {
           if (s.getTituloSerie().equalsIgnoreCase(serieParaDeletar)) {
               String confirmacao = leitura.lerString("Tem certeza que deseja deletar a série '" + s.getTituloSerie() + "'? (S/N)");

               if (confirmacao.equalsIgnoreCase("S")) {
                   series.remove(s);
                   System.out.println("Série removida com sucesso!");
               } else {
                   System.out.println("Exclusão cancelada.");
               }

               encontrada = true;
               break;
           }
       }

       if (!encontrada) {
           System.out.println("Série não encontrada para deletar.");
       }
    }
    
    public static void atualizarSerie(){
        String serieParaAtualizar = leitura.lerString("Qual série gostaria de ver?");
        boolean encontrada = false;
        
        for (Serie s : series) {
            if (!s.getTituloSerie().equalsIgnoreCase(serieParaAtualizar)) {
                encontrada = false;
                System.out.println("Serie não encontrada!");
            }else{
                boolean atualizarMais = false;
                do{
                    String atualizar = leitura.lerString("Gostaria de atualizar o título da série? (S/N)");
                    if(atualizar.equalsIgnoreCase("S")){
                        String novoTituloSerie = leitura.lerString("Qual o novo título da série?");
                        s.setTituloSerie(novoTituloSerie);
                    }                    
                }while(atualizarMais);
                
                //temporada.getnumero
                //episodio.getnumero
            }
               
        }    
    }
    
    public static void cadastrarSerie(){
        boolean querCadastrarMais;
        do {
            Serie novaSerie = new Serie();


            String tituloSerie = leitura.lerString("Qual o título da série?");
            novaSerie.setTituloSerie(tituloSerie);

            int notaSerie = leitura.lerInteiro("Qual nota esta série merece? (0 a 5)");
            do {
                notaSerie = leitura.lerInteiro("Qual a nota do episódio? (0 a 5)");
                    if (notaSerie < 0 || notaSerie > 5) {
                        System.out.println("Nota inválida. Tente novamente.");
                    }
                } while (notaSerie < 0 || notaSerie > 5);
            novaSerie.setNota(notaSerie);

            querCadastrarMais = false;
            int numeroTemporada = 1;

            do {
                Temporada temporada = new Temporada();
                temporada.setNumeroTp(numeroTemporada);

                List<Episodio> episodios = new ArrayList<>();
                boolean querCadastrarMaisEpisodios;
                int numeroEpisodio = 1;

                do {
                    Episodio episodio = new Episodio();
                    String tituloEp = leitura.lerString("Qual o título do episódio?");
                    episodio.setTitulo(tituloEp);

                    int notaEp;
                    do {
                        notaEp = leitura.lerInteiro("Qual a nota do episódio? (0 a 5)");
                        if (notaEp < 0 || notaEp > 5) {
                            System.out.println("Nota inválida. Tente novamente.");
                        }
                    } while (notaEp < 0 || notaEp > 5);
                    episodio.setAvaliacao(notaEp);

                    String comentarioEp = leitura.lerString("Deixe um comentário sobre o episódio:");
                    episodio.setComentario(comentarioEp);

                    int duracao = leitura.lerInteiro("Qual a duração do episódio em minutos?");
                    episodio.setDuracao(duracao);

                    episodio.setNumeroEp(numeroEpisodio);
                    episodios.add(episodio);
                    numeroEpisodio++;

                    String maisEpisodios = leitura.lerString("Gostaria de cadastrar mais episódios? (S/N)");
                    querCadastrarMaisEpisodios = maisEpisodios.equalsIgnoreCase("S");
                } while (querCadastrarMaisEpisodios);

                temporada.setEpisodios(episodios);
                String descricaoTp = leitura.lerString("Descreva a temporada:");
                temporada.setDescricao(descricaoTp);

                temporadas.add(temporada);
                numeroTemporada++;

                String maisTemporadas = leitura.lerString("Gostaria de cadastrar mais temporadas? (S/N)");
                querCadastrarMais = maisTemporadas.equalsIgnoreCase("S");
            } while (querCadastrarMais);

            series.add(novaSerie);

            String maisSeries = leitura.lerString("Gostaria de cadastrar mais séries? (S/N)");
            querCadastrarMais = maisSeries.equalsIgnoreCase("S");
        } while (querCadastrarMais);

        System.out.println("Série(s) cadastrada(s) com sucesso!");
    }
}
