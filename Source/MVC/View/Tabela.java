package MVC.View;

import javax.swing.table.*;
import java.util.*;

import MVC.Model.Disciplina.Disciplina;
import MVC.Model.Disciplina.DisciplinaCursada;

public class Tabela
{
    
    private static String[] getColHist()
    {
        String[] colHist = {"Materia cursada", "Carga Horaria", "Media Final", "Situacao"};
        return colHist;
    }

    public static DefaultTableModel getDefaulTabletHist()
    {
        DefaultTableModel defaultTableHist = new DefaultTableModel(Tabela.getColHist(), 0)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        return defaultTableHist;
    }

    public static void setTamanhoColunaHist(TableColumnModel column)
    {
        column.getColumn(0).setPreferredWidth(400);
        column.getColumn(0).setMaxWidth(400);
        column.getColumn(1).setPreferredWidth(200);
        column.getColumn(1).setMaxWidth(200);
        column.getColumn(2).setPreferredWidth(175);
        column.getColumn(2).setMaxWidth(175);
        column.getColumn(3).setPreferredWidth(175);
        column.getColumn(3).setMaxWidth(175);
    }

    public static void geraColunaHist(ArrayList<DisciplinaCursada> histEscolar, DefaultTableModel model)
    {
        for(DisciplinaCursada dispC : histEscolar)
        {
            String disc = dispC.getNomeAtivCurr();
            String chTotal = dispC.getChTotal();
            String mediaFinal = dispC.getMediaFinal();
            String situacao = dispC.getSituacao();
            Object[] info = {disc, chTotal, mediaFinal, situacao};
            model.addRow(info);
        }
    }

    public static void setTamanhoDisponiveis(TableColumnModel column)
    {
        column.getColumn(0).setPreferredWidth(400);
        column.getColumn(0).setMaxWidth(400);
        column.getColumn(1).setPreferredWidth(110);
        column.getColumn(1).setMaxWidth(110);
        column.getColumn(2).setPreferredWidth(135);
        column.getColumn(2).setMaxWidth(135);
        column.getColumn(3).setPreferredWidth(135);
        column.getColumn(3).setMaxWidth(135);
        column.getColumn(4).setPreferredWidth(135);
        column.getColumn(4).setMaxWidth(135);
    }

    public static void geraColunaDisponiveis(ArrayList<Disciplina> discs, DefaultTableModel model)
    {
        for(Disciplina disc : discs)
        {
            String nome = disc.getNomeDisciplina();
            String chTotal = disc.getCHTotal();
            String periodo = disc.getPeriodoIdeal();
            Boolean pedido = false;
            int prioridade = 0;
            Object[] info = {nome, periodo, chTotal, pedido, prioridade};
            model.addRow(info);
        }
    }

    public static void setTamanhoRestantes(TableColumnModel column)
    {
        column.getColumn(0).setPreferredWidth(400);
        column.getColumn(0).setMaxWidth(400);
        column.getColumn(1).setPreferredWidth(245);
        column.getColumn(1).setMaxWidth(245);
        column.getColumn(3).setPreferredWidth(270);
        column.getColumn(3).setMaxWidth(270);
    }

    public static void geraRestantes(ArrayList<Disciplina> discs, DefaultTableModel model)
    {
        for(Disciplina disc : discs)
        {
            String nome = disc.getNomeDisciplina();
            String chTotal = disc.getCHTotal();
            String periodo = disc.getPeriodoIdeal();
            Object[] info = {nome, periodo, chTotal};
            model.addRow(info);
        }
    }
}
