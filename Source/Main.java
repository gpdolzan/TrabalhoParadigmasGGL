import java.util.ArrayList;

import MVC.Model.Aluno.Aluno;
import MVC.Model.Disciplina.Disciplina;
import MVC.Model.Leitor.LeitorAluno;
import MVC.Model.Leitor.LeitorDisciplina;

public class Main
{
    public static void main(String[] args)
    {
        Aluno al = new Aluno();
        al = LeitorAluno.leAluno("TAP_historico.csv");
        al.printAluno();
        

        //ArrayList<Disciplina> disp = new ArrayList<Disciplina>();
        //disp = LeitorDisciplina.leDisciplinas("Disciplina_2019.csv");
        //for(Disciplina d : disp)
            //d.printDisc();
    }    
}