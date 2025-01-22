package com.mycompany.expooserie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarEpisodio extends JFrame {
    private JTextField txtTituloEp;
    private JTextField txtNotaEp;
    private JTextField txtDuracao;
    private JButton btCadastrar;
    private JButton btCancelar;
    private JTextField txtComentario;
    private JPanel painelEpisodio;
    private Serie serie = new Serie();

    public CadastrarEpisodio(CadastrarTemporada parent) {
        setContentPane(painelEpisodio);
        setTitle("Cadastrar Episódio");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //temporada.setDescricao() = txtDescricao.getText();
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

//    public static void main(String[] args) {
//        CadastrarTemporada ct = new CadastrarTemporada();
//    }
}
