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
    private JLabel funcionou;

    public CadastrarSerie() {
        setContentPane(painelSerie);
        setTitle("Cadastrar Serie");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // serie.setTitulo() = txtTituloSerie.getText(); ...
                funcionou.setText("Está funcionando?");
            }
        });


        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtTituloSerie.setText("");
                txtNotaSerie.setText("");
                //voltar
            }
        });
    }

    public static void main(String[] args) {
        CadastrarSerie cs = new CadastrarSerie();
    }
}

