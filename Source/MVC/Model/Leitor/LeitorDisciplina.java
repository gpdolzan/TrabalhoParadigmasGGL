package MVC.Model.Leitor;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import MVC.Model.Disciplina.Disciplina;

public class LeitorDisciplina
{
    static private Boolean jaExiste(Disciplina disp, ArrayList<Disciplina> disps)
    {
        for(Disciplina disc : disps)
        {
            if(disc.getNomeDisciplina().equals(disp.getNomeDisciplina()))
                return true;
        }
        return false;
    }

    static private ArrayList<Disciplina> ajustaCH(Disciplina disp, ArrayList<Disciplina> disps)
    {
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
        for(Disciplina disc : disps)
        {
            if(disc.getNomeDisciplina().equals(disp.getNomeDisciplina()))
            {
                Integer ajustadaCH = Integer.parseInt(disp.getNumHoras());
                ajustadaCH += Integer.parseInt(disc.getNumHoras());
                disc.setNumHoras(ajustadaCH.toString());
                disciplinas.add(disc);
            }
            else
            {
                disciplinas.add(disc);
            }
        }
        return disciplinas;
    }

    /* Lê arquivo CSV contendo todas as Disciplinas e armazena em uma arrayList */
    static public ArrayList<Disciplina> leDisciplinas(String nomeArq)
    {
        ArrayList<Disciplina> listDisciplinas = new ArrayList<Disciplina>();
        File arqDisciplinas = new File("Inputs/" + nomeArq);

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
                disc.setDescSituacao(leitor.next());

                leitor.useDelimiter("\n");
                disc.setCHTotal(leitor.next().substring(1));
                leitor.useDelimiter(";");

                if(jaExiste(disc, listDisciplinas) == true)
                {
                    listDisciplinas = ajustaCH(disc, listDisciplinas);
                }
                else
                {
                    listDisciplinas.add(disc); /* Adds Disciplina to arrayList*/
                }
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