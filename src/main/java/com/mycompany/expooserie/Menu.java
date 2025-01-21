package com.mycompany.expooserie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static com.mycompany.expooserie.Consts.CAMINHO_ARQUIVO;

public class Menu extends JFrame {
    private JButton btListar;
    private JButton btAtualizar;
    private JButton btCadastrar;
    private JButton btDeletar;
    private JButton btBuscar;
    private JButton btSair;
    private JPanel painelMenu;
    private List<Serie> series;
    private Menu menu;

    public Menu() {
        setContentPane(painelMenu);
        setTitle("Menu");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        series = new Importador().leitorArquivo(CAMINHO_ARQUIVO);
        menu = this;

        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new CadastrarSerie(menu);
                setVisible(false);
            }
        });


        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });


        btAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });


        btDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });


        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });


        btSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
    }
}
