/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.expooserie;

import java.util.ArrayList;


/**
 *
 * @author Jenni
 */
public class ExPooSerie {

    public static void main(String[] args) {
        Serie serie1 = new Serie ();
        serie1.setNota(5);
        serie1.setTituloSerie("Friends");
        
        Temporada temporada = new Temporada ();
        temporada.setNumeroTp(1);
        temporada.setDescricao("Uma grande confusão se aproxima");
        
        Episodio ep = new Episodio();
        ep.setAvaliacao(3);
        ep.setComentario("Relativamente chato, esperava mais ação");
        ep.setDuracao(45);
        ep.setNumeroEp(8);
        ep.setTitulo("AAAAAAAAAAAAAAAAAAA");
        
        Episodio ep2 = new Episodio();
        ep2.setAvaliacao(2);
        ep2.setComentario("confuso");
        ep2.setDuracao(27);
        ep2.setNumeroEp(7);
        ep2.setTitulo("só sei que nada sei");
        
        temporada.adicionarEpisodio(ep); 
        temporada.adicionarEpisodio(ep2);   
        
        Temporada temporada1 = new Temporada ();
        temporada1.setNumeroTp(2);
        temporada1.setDescricao("Uma grande confusão se aproxima");
        
        Episodio ep3 = new Episodio();
        ep3.setAvaliacao(4);
        ep3.setComentario("bbbbbbbb chato, esperava mais ação");
        ep3.setDuracao(50);
        ep3.setNumeroEp(2);
        ep3.setTitulo("BBBBBBBBBBB");
        
        Episodio ep4 = new Episodio();
        ep4.setAvaliacao(5);
        ep4.setComentario("testando 123");
        ep4.setDuracao(30);
        ep4.setNumeroEp(9);
        ep4.setTitulo("o melhor teste");
        
        temporada1.adicionarEpisodio(ep3); 
        temporada1.adicionarEpisodio(ep4);
        
        serie1.adicionarTemporada(temporada);
        serie1.adicionarTemporada(temporada1);
        
        System.out.print(serie1.toString());
        System.out.print(temporada.toString());
        System.out.print(temporada1.toString());

    }
}
