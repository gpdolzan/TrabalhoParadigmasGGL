package MVC.Model.Organizador;

import java.util.ArrayList;

import MVC.Model.Aluno.Aluno;
import MVC.Model.Disciplina.DisciplinaCursada;

public class OrganizadorAluno
{
    OrganizadorAluno(){}

    static ArrayList<DisciplinaCursada> removeMatriculadas(ArrayList<DisciplinaCursada> discs)
    {
        ArrayList<DisciplinaCursada> semMatriculas = new ArrayList<DisciplinaCursada>();
        for(DisciplinaCursada disc : discs)
        {
            if(disc.getSituacao().equals("Matrícula") == false)
                semMatriculas.add(disc);
        }
        return semMatriculas;
    }

    public static ArrayList<DisciplinaCursada> getMatriculadas(ArrayList<DisciplinaCursada> discs)
    {
        ArrayList<DisciplinaCursada> matriculadas = new ArrayList<DisciplinaCursada>();
        for(DisciplinaCursada disc : discs)
        {
            if(disc.getSituacao().equals("Matrícula") == true)
            matriculadas.add(disc);
        }
        return matriculadas;
    }

    static Integer getUltimoAno(ArrayList<DisciplinaCursada> discs)
    {
        String ano = discs.get(0).getNumVersao();

        for(DisciplinaCursada disc : discs)
        {
            if(Integer.parseInt(disc.getAno()) > Integer.parseInt(ano))
                ano = disc.getAno();
        }
        return Integer.parseInt(ano);
    }

    static String getUltimoSemestre(Integer intAno, ArrayList<DisciplinaCursada> discs)
    {
        String ultimoSemestre = "1o. Semestre";
        for(DisciplinaCursada disc : discs)
        {
            if(intAno.toString().equals(disc.getAno()))
            {
                if(ultimoSemestre.equals(disc.getPeriodo()) == false)
                {
                    if(disc.getSituacao().equals("Matricula") == false)
                    {
                        ultimoSemestre = disc.getPeriodo();
                    }
                }
            }
        }
        return ultimoSemestre;
    }

    static ArrayList<DisciplinaCursada> getUltimasCursadas(Aluno aluno)
    {
        ArrayList<DisciplinaCursada> histEscolar = aluno.getHistEscolar();
        ArrayList<DisciplinaCursada> ultimasCursadas = new ArrayList<DisciplinaCursada>();
        histEscolar = removeMatriculadas(histEscolar);
        Integer intAno = getUltimoAno(histEscolar);
        String ultimoSemestre = getUltimoSemestre(intAno, histEscolar);

        for(DisciplinaCursada disc : histEscolar)
        {
            if(disc.getAno().equals(intAno.toString()) && disc.getPeriodo().equals(ultimoSemestre))
                ultimasCursadas.add(disc);
        }
        return ultimasCursadas;
    }

    static ArrayList<Integer> getDados(ArrayList<DisciplinaCursada> discs)
    {
        ArrayList<Integer> dados = new ArrayList<Integer>();
        Integer reprovTotal = 0;
        Integer reprovNota = 0;
        Integer reprovFreq = 0;

        for(DisciplinaCursada disc : discs)
        {
            if(disc.getSituacao().equals("Aprovado") == false)
            {
                reprovTotal += 1;
                if(disc.getSituacao().equals("Reprovado por Frequência"))
                    reprovFreq += 1;
                else
                    reprovNota += 1;
            }
        }

        dados.add(reprovTotal);
        dados.add(reprovNota);
        dados.add(reprovFreq);
        dados.add(discs.size());

        return dados;
    }

    static double calculaIRA(ArrayList<DisciplinaCursada> discs)
    {
        Integer ch = 0;
        Integer nota = 0;
        Integer somatorio = 0;
        Integer chIRA = 0;
        double ira = 0;

        for(DisciplinaCursada disc : discs)
        {
            ch = Integer.parseInt(disc.getChTotal());
            chIRA += ch;
            nota = Integer.parseInt(disc.getMediaFinal());
            somatorio += ch * nota;
        }

        ira = somatorio.doubleValue() / chIRA.doubleValue();

        return (ira / 100);
    }

    public static Aluno calculaDadosAluno(Aluno aluno)
    {
        ArrayList<DisciplinaCursada> hist = removeMatriculadas(aluno.getHistEscolar());
        ArrayList<DisciplinaCursada> ultimasCursadas = getUltimasCursadas(aluno);
        ArrayList<Integer> dadosHist = getDados(hist);
        ArrayList<Integer> dadosCursadas = getDados(ultimasCursadas);
        double percentAprovTotal;
        double percentAprovAtual;

        aluno.setReprovTotal(dadosHist.get(0));
        aluno.setReprovNotaTotal(dadosHist.get(1));
        aluno.setReprovFaltaTotal(dadosHist.get(2));

        aluno.setReprovAtual(dadosCursadas.get(0));
        aluno.setReprovNotaAtual(dadosCursadas.get(1));
        aluno.setReprovFaltaAtual(dadosCursadas.get(2));

        percentAprovTotal = ((dadosHist.get(3).doubleValue() - dadosHist.get(0).doubleValue()) / dadosHist.get(3).doubleValue());
        percentAprovAtual = ((dadosCursadas.get(3).doubleValue() - dadosCursadas.get(0).doubleValue()) / dadosCursadas.get(3).doubleValue());
        aluno.setPercentAprovTotal(percentAprovTotal);
        aluno.setPercentAprovAtual(percentAprovAtual);

        aluno.setIra(calculaIRA(hist));

        return aluno;
    }
}
