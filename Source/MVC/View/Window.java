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
    public static void printWindow(Aluno al, ArrayList<Disciplina> disponiveis, ArrayList<Disciplina> restantes)
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
        JScrollPane scrollPaneHistorico = new JScrollPane(tHist, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tables.add(scrollPaneHistorico,BorderLayout.CENTER);

        /* Tabela Disponiveis */
        /*TABELA DE OFERTADAS BEGIN */
        JPanel panelOfertadas = new JPanel(new BorderLayout());
        DefaultTableModel modelOfertadas = new DefaultTableModel(Tabela.getColDisponiveis(), 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                switch(column){
                    case 3:
                    case 4:
                        return true;
                    default:
                        return false;    
                }
            }
        };
        JTable tableOfertadas= new JTable(modelOfertadas){
            @Override
            public Class getColumnClass(int column){
                switch(column){
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Boolean.class;
                    case 4:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }
        };
        
        TableColumnModel columnModelOfertadas = tableOfertadas.getColumnModel();
        Tabela.setTamanhoDisponiveis(columnModelOfertadas);
        Tabela.geraColunaDisponiveis(disponiveis, modelOfertadas);
        
        JScrollPane scrollPaneOfertadas = new JScrollPane(tableOfertadas,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton enviar = new JButton("Solicitar");
        panelOfertadas.add(scrollPaneOfertadas,BorderLayout.CENTER);
        panelOfertadas.add(enviar,BorderLayout.SOUTH);
        scrollPaneOfertadas.setPreferredSize(new Dimension(950,500));
        tables.add(panelOfertadas,BorderLayout.EAST);



        /*TABELA DE BARREIRA BEGIN */
        DefaultTableModel modelBarreira = new DefaultTableModel(Tabela.getColRestante(), 0)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };

        JTable tableBarreira = new JTable(modelBarreira);
        TableColumnModel columnModelBarreira = tableBarreira.getColumnModel();
        Tabela.setTamanhoRestantes(columnModelBarreira);
        Tabela.geraRestantes(restantes, modelBarreira);
        JPanel panelRestantes = new JPanel(new BorderLayout());
        JScrollPane scrollPaneBarreiras = new JScrollPane(tableBarreira,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneBarreiras.setPreferredSize(new Dimension(475,500));
        panelRestantes.add(scrollPaneBarreiras, BorderLayout.SOUTH);
        panelRestantes.add(scrollPaneBarreiras, BorderLayout.CENTER);
        frame.getContentPane().add(BorderLayout.SOUTH, panelRestantes);

        frame.setVisible(true);
        frame.getContentPane().add(BorderLayout.CENTER, tables);
    }
}