package MVC.Controller;

import java.util.ArrayList;

import MVC.Model.Aluno.Aluno;
import MVC.Model.Disciplina.Disciplina;
import MVC.Model.Leitor.LeitorAluno;
import MVC.Model.Leitor.LeitorDisciplina;
import MVC.Model.Organizador.OrganizadorAluno;
import MVC.Model.Organizador.OrganizadorDisciplina;
import MVC.View.Window;

public class Controller
{
    private static Controller controllerSingleton;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Disciplina> discDisponiveis;
    private ArrayList<Disciplina> discRestantesBarreira;
    private Aluno aluno;

    public static Controller getSingleton()
    {
        if(controllerSingleton == null)
            controllerSingleton = new Controller();
        return controllerSingleton;
    }

    public ArrayList<Disciplina> getDisciplinas() {return disciplinas;}
    public ArrayList<Disciplina> getDiscDisponiveis() {return discDisponiveis;}
    public ArrayList<Disciplina> getDiscRestantesBarreira() {return discRestantesBarreira;}
    public Aluno getAluno() {return aluno;}

    public void initializeAluno(String pathAluno)
    {
        this.aluno = LeitorAluno.leAluno(pathAluno);
        this.aluno = OrganizadorAluno.calculaDadosAluno(this.aluno);
    }

    public void initializeDisciplinas(String pathDisciplinas)
    {
        this.disciplinas = LeitorDisciplina.leDisciplinas(pathDisciplinas);
        this.discDisponiveis = OrganizadorDisciplina.removeOptativas(disciplinas);
        this.discDisponiveis = OrganizadorDisciplina.removeJaCursadas(this.aluno.getHistEscolar(), discDisponiveis);
        this.discRestantesBarreira = OrganizadorDisciplina.removeOptativas(disciplinas);
        this.discRestantesBarreira = OrganizadorDisciplina.getPreBarreira(discRestantesBarreira);
        this.discRestantesBarreira = OrganizadorDisciplina.removeJaCursadas(this.aluno.getHistEscolar(), discRestantesBarreira);
    }

    public void initializeGUI()
    {
        Window.printWindow(controllerSingleton);
    }

    public boolean checkSolicitacao(Integer numSolicitadas)
    {
        if(numSolicitadas > aluno.getSugerido())
            return false;
        return true;
    }
}
