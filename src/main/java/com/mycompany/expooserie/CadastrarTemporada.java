package com.mycompany.expooserie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarTemporada extends JFrame {
    private JTextField txtDescricao;
    private JTextField txtTituloEp;
    private JTextField txtNotaEp;
    private JTextField txtDuracao;
    private JButton btCadastrar;
    private JButton btCancelar;
    private JTextField txtComentario;
    private JPanel painelTemporada;

    public CadastrarTemporada() {
        setContentPane(painelTemporada);
        setTitle("Cadastrar Temporada");
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
                txtDescricao.setText("");
                txtTituloEp.setText("");
                txtNotaEp.setText("");
                txtDuracao.setText("");
                txtComentario.setText("");
                //voltar
            }
        });
    }

    public static void main(String[] args) {
        CadastrarTemporada ct = new CadastrarTemporada();
    }
}
