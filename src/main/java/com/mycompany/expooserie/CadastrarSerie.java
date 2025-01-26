package com.mycompany.expooserie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CadastrarSerie extends JFrame {
    private JTextField txtTituloSerie;
    private JTextField txtNotaSerie;
    private JButton btCancelar;
    private JButton btCadastrar;
    private JPanel painelSerie;
    private JButton btSalvar;
    private Utils utils= new Utils();
    private Serie serie;
    private CadastrarSerie cadastrarSerie;

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    private List<Temporada> temporadas;

    public CadastrarSerie(Menu parent, Serie serieAtualizar) {
        setContentPane(painelSerie);
        setTitle("Cadastrar Serie");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        parent.setVisible(false);
        serie = new Serie();
        cadastrarSerie = this;
        temporadas = new ArrayList<>();
        if(serieAtualizar != null){
            serie = serieAtualizar;
            txtTituloSerie.setText(serie.getTituloSerie());
            txtNotaSerie.setText(serie.getNota()+"");
        }

        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

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

        btSalvar.addActionListener(new ActionListener() {
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
                    return;
                }
                serie.setTemporadas(temporadas);
                if(serieAtualizar != null){
                    for(Serie serie1 : parent.getSeries()){
                        if(serieAtualizar.getTituloSerie().equals(serie.getTituloSerie())){
                            serie.setTituloSerie(serie.getTituloSerie());
                            serie.setNota(serie.getNota());
                        }
                    }
                    utils.mostrarAlerta("Série atualizada com sucesso!");
                    parent.setVisible(true);
                    dispose();
                }else {
                    parent.getSeries().add(serie);
                    int opcao = utils.mostarConfirmacao("Deseja cadastar mais uma série?");
                    if(opcao == JOptionPane.YES_OPTION){
                        txtTituloSerie.setText("");
                        txtNotaSerie.setText("");
                        temporadas = new ArrayList<>();
                        serie = new Serie();
                        return;
                    }
                    parent.setVisible(true);
                    dispose();
                }
            }
        });
    }

    //    public static void main(String[] args) {
//        CadastrarSerie cs = new CadastrarSerie();
//    }
}

