package com.mycompany.expooserie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarSerie extends JFrame {
    private JTextField txtBuscarSerie;
    private JButton btBuscar;
    private JButton btCancelar;
    private JPanel painelBuscar;
    private Serie serie;
    private Utils utils;

    public BuscarSerie(Menu parent, String modo) {
        setContentPane(painelBuscar);
        setTitle("Buscar Serie");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        utils = new Utils();

        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(Serie serieDoFor : parent.getSeries()){
                    if(serieDoFor.getTituloSerie().equals(txtBuscarSerie.getText())){
                        serie = serieDoFor;
                        break;
                    }
                }
                if(serie == null){
                    utils.mostrarErro("Série não encontrada");
                    return;
                }
                switch (modo) {
                    case "Atualizar":
                        new CadastrarSerie(parent, serie);
                }
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
}
