package com.mycompany.expooserie;

import javax.swing.*;

public class Utils {
    public void mostrarErro(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Erro no formulário", JOptionPane.ERROR_MESSAGE);

    }

    public void mostrarAlerta(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Confira a informção", JOptionPane.WARNING_MESSAGE);

    }
}
