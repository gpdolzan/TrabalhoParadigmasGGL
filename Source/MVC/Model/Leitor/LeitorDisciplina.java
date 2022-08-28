package MVC.Model.Leitor;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import MVC.Model.Disciplina.Disciplina;

public class LeitorDisciplina
{
    /* Lê arquivo CSV contendo todas as Disciplinas e armazena em uma arrayList */
    static public ArrayList<Disciplina> leDisciplinas(String nomeArq)
    {
        ArrayList<Disciplina> listDisciplinas = new ArrayList<Disciplina>();
        File arqDisciplinas = new File(nomeArq);

        try
        {
            Scanner leitor = new Scanner(arqDisciplinas);

            /* Skip starting lines and set Delimeter */
            leitor.nextLine();
            leitor.nextLine();
            leitor.useDelimiter(";");

            while(leitor.hasNext())
            {
                Disciplina disc = new Disciplina();

                disc.setCodCurso(leitor.next());
                disc.setNumVer(leitor.next());
                disc.setDescEstru(leitor.next());
                disc.setCodDisciplina(leitor.next());
                disc.setNomeUnidade(leitor.next());
                disc.setNomeDisciplina(leitor.next());
                disc.setPeriodoIdeal(leitor.next());
                disc.setNumHoras(leitor.next());
                disc.setTipoDisciplina(leitor.next());
                disc.setCHTotal(leitor.next());

                leitor.useDelimiter("\n");
                disc.setDescSituacao(leitor.next().substring(1));
                leitor.useDelimiter(";");

                listDisciplinas.add(disc); /* Adds Disciplina to arrayList*/
                leitor.nextLine();
            }
            leitor.close();
            return listDisciplinas;
        } 
        catch (IOException e)
        {
            System.out.println("Falha ao ler o arquivo!");
            e.printStackTrace();
            return listDisciplinas;
        }
    }
}