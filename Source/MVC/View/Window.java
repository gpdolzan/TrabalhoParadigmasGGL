package MVC.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import MVC.Model.Aluno.Aluno;
import MVC.Model.Disciplina.Disciplina;

public class Window
{
    public static void printWindow(Aluno al, ArrayList<Disciplina> disciplinas)
    {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.FLOOR);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1900,1000);

        /* Coloca Header no centro do janela */
        JLabel header = new JLabel("<html>Aluno: " + al.getNomePessoa() + "<br/>GRR: "
            + al.getMatrAluno() + "<br/>Aprovacao Total: " + df.format((al.getPercentAprovTotal()*100)) + "%" + 
            "<br/>Aprovacao Atual: " + df.format((al.getPercentAprovAtual()*100)) + "%" + 
            "<br/>IRA: " + df.format(al.getIra()) + "<html>");
        frame.getContentPane().add(BorderLayout.NORTH, header);

        JPanel tables = new JPanel(new BorderLayout());

        /* Tabela Historico */
        DefaultTableModel defaultTableHist = Tabela.getDefaulTabletHist();
        JTable tHist = new JTable(defaultTableHist);
        TableColumnModel columnHist = tHist.getColumnModel();
        Tabela.setTamanhoColunaHist(columnHist);
        Tabela.geraColunaHist(al.getHistEscolar(), defaultTableHist);
        JScrollPane scrollPaneHistorico = new JScrollPane(tHist,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tables.add(scrollPaneHistorico,BorderLayout.WEST);

        /* Tabela Disponiveis */
        JPanel panelDisponiveis = new JPanel(new BorderLayout());
        DefaultTableModel defaultTableDisponiveis = Tabela.getDefaulTabletDisponiveis();
        JTable tDisponiveis = new JTable(defaultTableDisponiveis)
        {
            @Override
            public Class getColumnClass(int columns)
            {
                switch(columns)
                {
                    case 2:
                        return Boolean.class;
                    case 3:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }
        };
        TableColumnModel columnDisponiveis = tDisponiveis.getColumnModel();
        Tabela.setTamanhoDisponiveis(columnDisponiveis);
        Tabela.geraColunaDisponiveis(disciplinas, defaultTableDisponiveis);

        frame.setVisible(true);
        JScrollPane scrollPanelOfertadas = new JScrollPane(tDisponiveis,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton solicitacao = new JButton("Gerar Solicitacao");
        panelDisponiveis.add(scrollPanelOfertadas, BorderLayout.EAST);
        panelDisponiveis.add(solicitacao, BorderLayout.SOUTH);
        scrollPanelOfertadas.setPreferredSize(new Dimension(950, 500));
        tables.add(scrollPanelOfertadas, BorderLayout.EAST);

        frame.getContentPane().add(BorderLayout.CENTER, tables);
    }
}