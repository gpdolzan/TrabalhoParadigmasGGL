package MVC.Model.Organizador;

import java.util.ArrayList;

import MVC.Model.Disciplina.Disciplina;
import MVC.Model.Leitor.LeitorDisciplina;
import MVC.Model.Disciplina.DisciplinaCursada;

public class OrganizadorDisciplina
{
    OrganizadorDisciplina(){}
    
    static public ArrayList<Disciplina> removeOptativas(ArrayList<Disciplina> disciplinas)
    {
        ArrayList<Disciplina> semOpts = new ArrayList<Disciplina>();

        for(Disciplina disp : disciplinas)
        {
            if(disp.getTipoDisciplina().equals("Obrigatória") && ((disp.getNomeDisciplina().contains("TRABALHO DE CONCLUSÃO DE CURSO") == false) || (disp.getDescEstru().contains("Trabalho de Graduação") == false)) && (disp.getDescEstru().contains("Atividades Formativas Complementares") == false))
                semOpts.add(disp);
        }

        return semOpts;
    }

    static public ArrayList<Disciplina> getPreBarreira(ArrayList<Disciplina> disciplinas)
    {
        ArrayList<Disciplina> preBarreira = new ArrayList<Disciplina>();

        for(Disciplina disp : disciplinas)
        {
            if(Integer.parseInt(disp.getPeriodoIdeal()) < 4)
                preBarreira.add(disp);
        }
        return preBarreira;
    }

    static public ArrayList<Disciplina> getPosBarreira(ArrayList<Disciplina> disciplinas)
    {
        ArrayList<Disciplina> posBarreira = new ArrayList<Disciplina>();

        for(Disciplina disp : disciplinas)
        {
            if(Integer.parseInt(disp.getPeriodoIdeal()) >= 4)
                posBarreira.add(disp);
        }
        return posBarreira;
    }

    static private Boolean jaCursou(Disciplina disp, ArrayList<DisciplinaCursada> histEscolar)
    {
        for(DisciplinaCursada dispC : histEscolar)
        {
            if(dispC.getCodAtivCurr().equals(disp.getCodDisciplina()) == true)
            {
                if(dispC.getSituacao().equals("Aprovado") || dispC.getSituacao().equals("Matrícula"))
                {
                    return true;
                }
            }
        }
        return false;
    }

    static public ArrayList<Disciplina> removeJaCursadas(ArrayList<DisciplinaCursada> histEscolar, ArrayList<Disciplina> disciplinas)
    {
        ArrayList<Disciplina> naoCursadas = new ArrayList<Disciplina>();
        for(Disciplina disp : disciplinas)
        {
            if(jaCursou(disp, histEscolar) == false)
            {
                naoCursadas.add(disp);
            }
        }
        return naoCursadas;
    }
}
