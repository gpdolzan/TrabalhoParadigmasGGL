import java.util.ArrayList;

import MVC.Model.Aluno.Aluno;
import MVC.Model.Disciplina.Disciplina;
import MVC.Model.Leitor.LeitorAluno;
import MVC.Model.Leitor.LeitorDisciplina;
import MVC.Model.Organizador.OrganizadorAluno;
import MVC.View.Window;

/*import java.util.ArrayList;

import MVC.Model.Aluno.*;
import MVC.Model.Disciplina.*;
import MVC.Model.Leitor.*;
import MVC.Model.Organizador.*;

public class Main
{
    public static void main(String[] args)
    {
        Aluno al = new Aluno();
        al = LeitorAluno.leAluno("TAP_historico.csv");
        al = OrganizadorAluno.calculaDadosAluno(al);

        ArrayList<Disciplina> disp = new ArrayList<Disciplina>();
        disp = LeitorDisciplina.leDisciplinas("Disciplina_2011.csv");
        ArrayList<Disciplina> semOpts = OrganizadorDisciplina.removeOptativas(disp);
        ArrayList<Disciplina> preBarreira = OrganizadorDisciplina.getPreBarreira(semOpts);
        ArrayList<Disciplina> naoCursadas = OrganizadorDisciplina.removeJaCursadas(al.getHistEscolar(), preBarreira);
        System.out.println("Size = " + naoCursadas.size());
        for(Disciplina d : naoCursadas)
            d.printDisc();
    }    
}*/


public class Main
{
    public static void main(String[] args)
    {
        Aluno al = LeitorAluno.leAluno("TAP_historico.csv");
        ArrayList<Disciplina> disp = LeitorDisciplina.leDisciplinas("Disciplina_2011.csv");
        OrganizadorAluno.calculaDadosAluno(al);
        Window.printWindow(al, disp);
    }
}