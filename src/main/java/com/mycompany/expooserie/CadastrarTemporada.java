package com.mycompany.expooserie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CadastrarTemporada extends JFrame {
    private JPanel painelTemproada;
    private JTextField txtDescricao;
    private JButton btCadastrar;
    private JButton btCancelar;
    private Utils utils = new Utils();
    private Temporada temporada = new Temporada();
    private CadastrarTemporada cadastrarTemporada;

    public CadastrarTemporada(CadastrarSerie cadastrarSerie) {
        setContentPane(painelTemproada);
        setTitle("Cadastrar Temporada");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        cadastrarTemporada = this;


        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String descricao = txtDescricao.getText();
                if(descricao.isEmpty()){
                    utils.mostrarAlerta("A descrição está vazia");
                    return;
                }
                new CadastrarEpisodio(cadastrarTemporada);
                setVisible(false);
            }
        });


        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cadastrarSerie.setVisible(true);
                dispose();
            }
        });
    }
}
