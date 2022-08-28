import MVC.Model.Aluno.Aluno;
import MVC.Model.Leitor.LeitorAluno;

public class Main
{
    public static void main(String[] args)
    {
        Aluno al = new Aluno();
        System.out.println("Hello!");
        al = LeitorAluno.leAluno("exemplo_trabalho_TAP_historico.csv");
        al.printAluno();
    }    
}