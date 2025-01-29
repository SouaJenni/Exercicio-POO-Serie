/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expooserie.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {

    public String lerString(String rotulo){
        String retorno = " ";
        System.out.println(rotulo);
        
        BufferedReader memoria = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            retorno = memoria.readLine();
        } catch (IOException objIO) {
            System.out.println("\n Erro de sistema");
        }
        
        return retorno;
    }

    public int lerInteiro(String rotulo){
        Integer leituraInt=null;
        boolean isValido;
        do{
            try {
                String valorLido = lerString(rotulo);
                leituraInt = Integer.parseInt(valorLido);
                isValido=true;
            } catch (Exception e) {
                System.out.println("A opcao deve ser um numero inteiro");
                isValido=false;
            }
        }while(!isValido);

        return leituraInt;
    }

    public float lerFloat(String rotulo){
        Float leiturafloat=null;
        boolean isValido;
        do{
            try {
                String valorLido = lerString(rotulo);
                leiturafloat = Float.parseFloat(valorLido);
                isValido=true;
            } catch (Exception e) {
                System.out.println("A opcao deve ser um numero com os decimais separados por .");
                isValido=false;
            }
        }while(!isValido);
        return leiturafloat;
    }
}
