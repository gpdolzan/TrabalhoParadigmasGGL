package Source;

import Source.MVC.Model.Aluno.Aluno;
import Source.MVC.Model.Leitor.LeitorAluno;

public class Main
{
    public static void main(String[] args)
    {
        Aluno al = new Aluno();
        al = LeitorAluno.leAluno("./Inputs/exemplo_trabalho_TAP_historico.csv");
        al.printAluno();
    }    
}
