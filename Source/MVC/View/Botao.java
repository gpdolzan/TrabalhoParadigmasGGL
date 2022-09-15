package MVC.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class Botao
{
    public static JFrame getConfirmationBox(String frase)
    {
        JFrame confirmacao = new JFrame("Confirmacao");
        confirmacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        confirmacao.setResizable(false);
        confirmacao.setSize(400,300);
        JLabel confirmado = new JLabel(frase);
        confirmacao.getContentPane().add(BorderLayout.CENTER, confirmado);
        return confirmacao;
    }
}
