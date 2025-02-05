package com.mycompany.expooserie.view;

import com.mycompany.expooserie.controller.Exportador;
import com.mycompany.expooserie.controller.Importador;
import com.mycompany.expooserie.controller.ImportadorDB;
import com.mycompany.expooserie.model.Serie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static com.mycompany.expooserie.controller.Consts.CAMINHO_ARQUIVO;

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

    public List<Serie> getSeries() {
        return series;
    }


    public Menu() {
        setContentPane(painelMenu);
        setTitle("Menu");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
//       series = new Importador().leitorArquivo(CAMINHO_ARQUIVO);
        series = new ImportadorDB().leitorBancoDeDados();
        menu = this;

        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new CadastrarSerie(menu, null);
                setVisible(false);
            }
        });


        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ImprimeSerie(menu, null);
                setVisible(false);
            }
        });


        btAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new BuscarSerie(menu, "Atualizar");
                setVisible(false);
            }
        });


        btDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new BuscarSerie(menu, "Deletar");
                setVisible(false);
            }
        });


        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new BuscarSerie(menu, "Buscar");
                setVisible(false);
            }
        });


        btSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Exportador().salvarArquivo(CAMINHO_ARQUIVO, series);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
    }
}
