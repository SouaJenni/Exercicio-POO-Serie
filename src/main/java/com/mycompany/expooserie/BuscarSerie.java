package com.mycompany.expooserie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarSerie extends JFrame {
    private JTextField txtBuscarSerie;
    private JButton btBuscar;
    private JButton btCancelar;
    private JPanel painelBuscar;

    public BuscarSerie(Menu menu) {
        setContentPane(painelBuscar);
        setTitle("Buscar Serie");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });


        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                menu.setVisible(true);
                dispose();
            }
        });
    }
}
