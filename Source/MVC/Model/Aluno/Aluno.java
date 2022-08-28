package MVC.Model.Aluno;

import java.util.ArrayList;
import MVC.Model.Disciplina.DisciplinaCursada;

public class Aluno
{
    private String matrAluno;
    private String nomePessoa;
    private double percentAprov;
    private int reprovTotal;
    private int reprovNota;
    private int reprovFalta;
    private ArrayList<DisciplinaCursada> histEscolar;

    /* Constructor */
    public Aluno(){}

    /* Get and Set */
    public String getMatrAluno() {return matrAluno;}
    public String getNomePessoa() {return nomePessoa;}
    public double getPercentAprov() {return percentAprov;}
    public int getReprovTotal() {return reprovTotal;}
    public int getReprovNota() {return reprovNota;}
    public int getReprovFalta() {return reprovFalta;}
    public ArrayList<DisciplinaCursada> getHistEscolar() {return histEscolar;}

    public void setMatrAluno(String matrAluno) {this.matrAluno = matrAluno;}
    public void setNomePessoa(String nomePessoa) {this.nomePessoa = nomePessoa;}
    public void setPercentAprov(double percentAprov) {this.percentAprov = percentAprov;}
    public void setReprovTotal(int reprovTotal) {this.reprovTotal = reprovTotal;}
    public void setReprovNota(int reprovNota) {this.reprovNota = reprovNota;}
    public void setReprovFalta(int reprovFalta) {this.reprovFalta = reprovFalta;}
    public void setHistEscolar(ArrayList<DisciplinaCursada> histEscolar) {this.histEscolar = histEscolar;}

    public void printAluno()
    {
        System.out.println("---------------------------");
        System.out.println("codCurso = " + matrAluno);
        System.out.println("numVer = " + nomePessoa);
        System.out.println("numVer = " + percentAprov);
        System.out.println("numVer = " + reprovTotal);
        System.out.println("numVer = " + reprovNota);
        System.out.println("numVer = " + reprovFalta);
        for(DisciplinaCursada x : histEscolar)
        {
            x.printDiscCursada();
        }
    }
}