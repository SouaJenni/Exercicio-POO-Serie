package com.mycompany.expooserie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImprimeSerie extends JFrame {

    private JScrollPane scrollPane;
    private JPanel painelImprime;
    private JTextArea areaDeTexto;
    private JButton btVoltar;

    public ImprimeSerie (Menu menu) {
        setContentPane(painelImprime);
        setTitle("Séries cadastradas");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                menu.setVisible(true);
                dispose();
            }
        });
    }

//    public static void main(String[] args) {
//        ImprimeSerie imprime = new ImprimeSerie(null);
//    }
}
