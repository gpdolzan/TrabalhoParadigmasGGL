package MVC.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.Position;

import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import MVC.Controller.Controller;

public class Window
{
    public static void printWindow(Controller ctrl)
    {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.FLOOR);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1900,1000);

        /* Coloca Header no centro do janela */
        JLabel header = new JLabel("<html>Aluno: " + ctrl.getAluno().getNomePessoa() + "<br/>GRR: "
            + ctrl.getAluno().getMatrAluno() + "<br/>Aprovacao Total: " + df.format((ctrl.getAluno().getPercentAprovTotal()*100)) + "%" + 
            "<br/>Aprovacao Ultimo Periodo: " + df.format((ctrl.getAluno().getPercentAprovAtual()*100)) + "%" + 
            "<br/>Reprovacoes por Frequencia no Ultimo Periodo: " + ctrl.getAluno().getReprovFaltaAtual() +
            "<br/>IRA: " + df.format(ctrl.getAluno().getIra()) + 
            "<br/>Desempenho do Aluno: " + ctrl.getAluno().getDesempenho() + " = " + ctrl.getAluno().getSugerido() + "<html>");
        frame.getContentPane().add(BorderLayout.NORTH, header);

        JPanel tables = new JPanel(new BorderLayout());

        /* Tabela Historico */
        DefaultTableModel defaultTableHist = Tabela.getDefaulTabletHist();
        JTable tHist = new JTable(defaultTableHist);
        TableColumnModel columnHist = tHist.getColumnModel();
        Tabela.setTamanhoColunaHist(columnHist);
        Tabela.geraColunaHist(ctrl.getAluno().getHistEscolar(), defaultTableHist);
        JScrollPane scrollPaneHistorico = new JScrollPane(tHist, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tables.add(scrollPaneHistorico,BorderLayout.CENTER);

        /* Tabela Disponiveis */
        JPanel panelOfertadas = new JPanel(new BorderLayout());
        DefaultTableModel defaultDisponiveis = Tabela.getDefaulTabletDisponiveis();
        JTable tDisponiveis = Tabela.getJTableDisponiveis(defaultDisponiveis);
        TableColumnModel columnDisponiveis = tDisponiveis.getColumnModel();
        Tabela.setTamanhoDisponiveis(columnDisponiveis);
        Tabela.geraColunaDisponiveis(ctrl.getDiscDisponiveis(), defaultDisponiveis);
        JScrollPane scrollPaneOfertadas = new JScrollPane(tDisponiveis,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JButton solicitar = new JButton("Solicitar");
        panelOfertadas.add(scrollPaneOfertadas,BorderLayout.CENTER);
        panelOfertadas.add(solicitar,BorderLayout.SOUTH);
        scrollPaneOfertadas.setPreferredSize(new Dimension(950,600));
        tables.add(panelOfertadas,BorderLayout.EAST);

        /* Tabela Restantes */
        DefaultTableModel defaultRestantes = Tabela.getDefaultRestantes();
        JTable tableBarreira = new JTable(defaultRestantes);
        TableColumnModel columnModelBarreira = tableBarreira.getColumnModel();
        Tabela.setTamanhoRestantes(columnModelBarreira);
        Tabela.geraRestantes(ctrl.getDiscRestantesBarreira(), defaultRestantes);
        JPanel panelRestantes = new JPanel(new BorderLayout());
        JScrollPane scrollPaneBarreiras = new JScrollPane(tableBarreira,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneBarreiras.setPreferredSize(new Dimension(475,400));
        panelRestantes.add(scrollPaneBarreiras, BorderLayout.SOUTH);
        panelRestantes.add(scrollPaneBarreiras, BorderLayout.CENTER);
        frame.getContentPane().add(BorderLayout.SOUTH, panelRestantes);

        /* Deixa tudo visivel */
        frame.setVisible(true);
        frame.getContentPane().add(BorderLayout.CENTER, tables);

        /* Ajusta caracteristicas do botao */
        solicitar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ArrayList<String> nomesDisciplinas = new ArrayList<String>();
                ArrayList<Integer> prioridades = new ArrayList<Integer>();
                for (int i = 0; i < tDisponiveis.getRowCount(); i++)
                {
                    String nomeDisciplina = (String) tDisponiveis.getValueAt(i,0);
                    Boolean marcado = (Boolean) tDisponiveis.getValueAt(i, 3);
                    if(marcado)
                    {
                        nomesDisciplinas.add(nomeDisciplina);
                        Integer prioridade = (Integer) tDisponiveis.getValueAt(i, 4);
                        if(prioridade == null)
                            prioridade = 0;
                        prioridades.add(prioridade);
                    }
                }
                if(nomesDisciplinas.size() != 0)
                {
                    if(ctrl.checkSolicitacao(nomesDisciplinas.size()) == true)
                    {
                        JFrame confirmacao = new JFrame("Confirmacao");
                        confirmacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        confirmacao.setResizable(false);
                        confirmacao.setSize(400,300);
                        JLabel msg = new JLabel("Solicitacao salva na pasta ./Outputs");
                        JButton bt = new JButton("OK");
                        confirmacao.getContentPane().add(BorderLayout.CENTER, msg);
                        confirmacao.getContentPane().add(BorderLayout.SOUTH, bt);
                        confirmacao.setLocationRelativeTo(null);
                        confirmacao.setVisible(true);
                        bt.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                confirmacao.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                            }          
                         });
                    }
                    else
                    {
                        JFrame confirmacao = new JFrame("Confirmacao");
                        confirmacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        confirmacao.setResizable(false);
                        confirmacao.setSize(400,300);
                        JLabel msg = new JLabel("<html>Voce solicitou: " + nomesDisciplinas.size() + " Disciplinas<br/>" + "Sugerido: " + ctrl.getAluno().getSugerido()
                        + " Disciplinas"
                        +"<br/>Deseja continuar?<html/>");

                        JPanel panel1 = new JPanel();
                        JButton btn = new JButton("CANCELAR"); // Button is a Component
                        btn.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                confirmacao.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                            }          
                        });
                        panel1.add(btn);

                        JPanel panel2 = new JPanel();
                        JButton btn2 = new JButton("CONTINUAR"); // Button is a Component
                        btn2.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                confirmacao.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

                                JFrame confirmacao = new JFrame("Confirmacao");
                                confirmacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                confirmacao.setResizable(false);
                                confirmacao.setSize(400,300);
                                JLabel msg = new JLabel("Solicitacao salva na pasta ./Outputs");
                                JButton bt = new JButton("OK");
                                confirmacao.getContentPane().add(BorderLayout.CENTER, msg);
                                confirmacao.getContentPane().add(BorderLayout.SOUTH, bt);
                                confirmacao.setLocationRelativeTo(null);
                                confirmacao.setVisible(true);
                                bt.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        confirmacao.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                                    }          
                                });
                            }          
                        });
                        panel2.add(btn2);

                        // A JPanel to hold both panel1 and panel2
                        JPanel containerPanel = new JPanel(new GridLayout(2, 1));
                        containerPanel.add(panel1);
                        containerPanel.add(panel2);

                        confirmacao.getContentPane().add(BorderLayout.CENTER, msg);
                        confirmacao.getContentPane().add(BorderLayout.SOUTH, containerPanel);

                        confirmacao.setLocationRelativeTo(null);
                        confirmacao.setVisible(true);
                    }
                }
            }
        });
    }
}