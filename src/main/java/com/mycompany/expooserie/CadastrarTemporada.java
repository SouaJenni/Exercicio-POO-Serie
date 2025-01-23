package com.mycompany.expooserie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class CadastrarTemporada extends JFrame {
    private JPanel painelTemproada;
    private JTextField txtDescricao;
    private JButton btCadastrar;
    private JButton btCancelar;
    private JButton btSalvar;
    private Utils utils = new Utils();
    private Temporada temporada = new Temporada();
    private CadastrarTemporada cadastrarTemporada;
    private List<Episodio> episodios;

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    public CadastrarTemporada(CadastrarSerie parent) {
        setContentPane(painelTemproada);
        setTitle("Cadastrar Temporada");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        cadastrarTemporada = this;
        episodios = new ArrayList<>();


        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                temporada.setEpisodios(episodios);
                new CadastrarEpisodio(cadastrarTemporada);
                setVisible(false);
            }
        });

        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.setVisible(true);
                dispose();
            }
        });

        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String descricao = txtDescricao.getText();
                if(descricao.isEmpty()){
                    utils.mostrarAlerta("A descrição está vazia");
                    return;
                }
                temporada.setDescricao(descricao);
                if(episodios.isEmpty()){
                    utils.mostrarAlerta("Você deve cadastrar pelo menos um episódio");
                    return;
                }
                temporada.setNumeroTp(parent.getTemporadas().size()+1);
                parent.getTemporadas().add(temporada);
                int opcao = utils.mostarConfirmacao("Gostaria de cadastrar mais uma temporada?");
                if(opcao == JOptionPane.YES_OPTION){
                    txtDescricao.setText("");
                    temporada = new Temporada();
                    episodios = new ArrayList<>();
                    return;
                }
                parent.setVisible(true);
                dispose();
            }
        });
    }
}
