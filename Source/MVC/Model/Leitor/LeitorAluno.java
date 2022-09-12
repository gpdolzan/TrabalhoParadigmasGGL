package MVC.Model.Leitor;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import MVC.Model.Aluno.Aluno;
import MVC.Model.Disciplina.DisciplinaCursada;

public class LeitorAluno
{   
    /* Lê arquivo CSV contendo todas as informações do Aluno */
    static public Aluno leAluno(String nomeArq)
    {
        Aluno aluno = new Aluno();
        ArrayList<DisciplinaCursada> listCursadas = new ArrayList<DisciplinaCursada>();
        File arqAluno = new File("Inputs/" + nomeArq);

        Integer reprovNota = 0;
        Integer reprovFalta = 0;
        Integer matriculadas = 0;
        String status;

        try
        {
            Scanner leitor = new Scanner(arqAluno);

            /* Skip starting lines and set Delimeter */
            leitor.nextLine();
            leitor.nextLine();
            leitor.useDelimiter(";");

            while(leitor.hasNext())
            {
                DisciplinaCursada discCursada = new DisciplinaCursada();

                aluno.setMatrAluno(leitor.next());
                aluno.setNomePessoa(leitor.next());

                discCursada.setCodCurso(leitor.next());
                discCursada.setNomeCurso(leitor.next());
                discCursada.setNumVersao(leitor.next());
                discCursada.setAno(leitor.next());
                discCursada.setMediaFinal(leitor.next());
                discCursada.setSituacaoItem(leitor.next());
                discCursada.setPeriodo(leitor.next());
                discCursada.setSituacao(leitor.next());
                discCursada.setCodAtivCurr(leitor.next());
                discCursada.setNomeAtivCurr(leitor.next());
                discCursada.setChTotal(leitor.next());
                discCursada.setDescrEstru(leitor.next());
                discCursada.setFrequencia(leitor.next());

                leitor.useDelimiter("\n");
                discCursada.setSigla(leitor.next().substring(1));
                leitor.useDelimiter(";");

                status = discCursada.getSituacao();
                System.out.println(status);
                if(status.equals("Reprovado por nota"))
                {
                    reprovNota += 1;
                }
                else if(status.equals("Reprovado por Frequência"))
                {
                    reprovFalta += 1;
                }
                else if(status.equals("Matrícula"))
                {
                    matriculadas += 1;
                }

                listCursadas.add(discCursada); /* Adds Disciplina to arrayList*/
                leitor.nextLine();
            }
            leitor.close();
            aluno.setHistEscolar(listCursadas);

            aluno.setReprovTotal(reprovNota + reprovFalta);
            aluno.setReprovFalta(reprovFalta);
            aluno.setReprovNota(reprovNota);
            aluno.setPercentAprov(calculaPercentAprov((listCursadas.size()- matriculadas), (reprovNota + reprovFalta)));

            return aluno;
        } 
        catch (IOException e)
        {
            System.out.println("Falha ao ler o arquivo!");
            e.printStackTrace();
            aluno.setHistEscolar(listCursadas);
            return aluno;
        }
    }

    static double calculaPercentAprov(Integer totalDisc, Integer totalReprov)
    {
        return ((totalDisc.doubleValue() - totalReprov.doubleValue()) / (totalDisc.doubleValue()));
    }
}