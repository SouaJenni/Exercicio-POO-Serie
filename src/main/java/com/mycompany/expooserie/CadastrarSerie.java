package com.mycompany.expooserie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarSerie extends JFrame {
    private JTextField txtTituloSerie;
    private JTextField txtNotaSerie;
    private JButton btCancelar;
    private JButton btCadastrar;
    private JPanel painelSerie;
    private Utils utils= new Utils();
    private Serie serie;
    private CadastrarSerie cadastrarSerie;

    public CadastrarSerie(Menu parent) {
        setContentPane(painelSerie);
        setTitle("Cadastrar Serie");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        serie = new Serie();
        cadastrarSerie = this;

        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String titulo = txtTituloSerie.getText();
                if(titulo.isEmpty()){
                    utils.mostrarAlerta("Informe o título");
                    return;
                }
                try {
                    Integer nota = Integer.parseInt(txtNotaSerie.getText());
                    if(nota < 0 || nota > 5){
                        utils.mostrarAlerta("Nota inválida");
                        return;
                    }
                    serie.setTituloSerie(titulo);
                    serie.setNota(nota);
                } catch (NumberFormatException e) {
                    utils.mostrarErro("A nota digitada não é um número");
                }
                new CadastrarTemporada(cadastrarSerie);
                setVisible(false);
            }
        });


        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               parent.setVisible(true);
               dispose();
            }
        });
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    //    public static void main(String[] args) {
//        CadastrarSerie cs = new CadastrarSerie();
//    }
}

