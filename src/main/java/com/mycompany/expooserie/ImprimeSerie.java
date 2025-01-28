package com.mycompany.expooserie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImprimeSerie extends JFrame {

    private JScrollPane scrollPane;
    private JPanel painelImprime;
    private JTextArea areaDeTexto;
    private JButton btVoltar;

    public JTextArea getAreaDeTexto() {
        return areaDeTexto;
    }

    public void setAreaDeTexto(JTextArea areaDeTexto) {
        this.areaDeTexto = areaDeTexto;
    }

    public ImprimeSerie (Menu parent, Serie serieBuscada) {
        setContentPane(painelImprime);
        setTitle("Séries cadastradas");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        if(serieBuscada != null) {
            areaDeTexto.setText(serieBuscada.toString());
        }else {
            String texto = "";
            for (Serie serie : parent.getSeries()) {
                texto += serie.toString() + "\n";
            }
            areaDeTexto.setText(texto);
        }

        btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.setVisible(true);
                dispose();
            }
        });
    }

//    public static void main(String[] args) {
//        ImprimeSerie imprime = new ImprimeSerie(null);
//    }
}
