package com.mycompany.expooserie.view;

import com.mycompany.expooserie.model.Episodio;
import com.mycompany.expooserie.controller.Utils;

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
    private Utils utils;

    public CadastrarEpisodio(CadastrarTemporada parent) {
        setContentPane(painelEpisodio);
        setTitle("Cadastrar Episódio");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        utils = new Utils();

        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String titulo = txtTituloEp.getText();
                int nota;
                int duracao;
                try {
                    nota = Integer.parseInt(txtNotaEp.getText());
                    duracao = Integer.parseInt(txtDuracao.getText());
                } catch (NumberFormatException e) {
                    utils.mostrarAlerta("Preencha todos os valores");
                    return;
                }
                String comentario = txtComentario.getText();

                if(titulo.isEmpty()){
                    utils.mostrarAlerta("Informe o título");
                    return;
                }
                if(nota<0 || nota>5){
                    utils.mostrarAlerta("Informe a nota");
                    return;
                }
                if(comentario.isEmpty()){
                    utils.mostrarAlerta("Adicione um comentário");
                    return;
                }
                Episodio episodio = new Episodio();
                episodio.setTitulo(titulo);
                episodio.setDuracao(duracao);
                episodio.setAvaliacao(nota);
                episodio.setComentario(comentario);
                episodio.setNumeroEp(parent.getEpisodios().size()+1);
                parent.getEpisodios().add(episodio);
                int opcao = utils.mostarConfirmacao("Quer adicionar mais episódios?");
                if(opcao == JOptionPane.YES_OPTION){
                    txtTituloEp.setText("");
                    txtNotaEp.setText("");
                    txtDuracao.setText("");
                    txtComentario.setText("");
                    return;
                }
                parent.setVisible(true);
                dispose();
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
