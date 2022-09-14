package MVC.Model.Aluno;

import java.util.ArrayList;
import MVC.Model.Disciplina.DisciplinaCursada;

public class Aluno
{
    private String matrAluno;
    private String nomePessoa;
    private Double percentAprovTotal;
    private Double percentAprovAtual;
    private Double ira;
    private int reprovTotal;
    private int reprovNotaTotal;
    private int reprovFaltaTotal;
    private int reprovAtual;
    private int reprovNotaAtual;
    private int reprovFaltaAtual;
    private int periodoAtual;
    private ArrayList<DisciplinaCursada> histEscolar;

    /* Constructor */
    public Aluno(){}

    /* Get and Set */
    public String getMatrAluno() {return matrAluno;}
    public String getNomePessoa() {return nomePessoa;}
    public Double getPercentAprovTotal() {return percentAprovTotal;}
    public Double getPercentAprovAtual() {return percentAprovAtual;}
    public Double getIra() {return ira;}
    public int getReprovTotal() {return reprovTotal;}
    public int getReprovNotaTotal() {return reprovNotaTotal;}
    public int getReprovFaltaTotal() {return reprovFaltaTotal;}
    public int getReprovAtual() {return reprovAtual;}
    public int getReprovNotaAtual() {return reprovNotaAtual;}
    public int getReprovFaltaAtual() {return reprovFaltaAtual;}
    public int getPeriodoAtual() {return periodoAtual;}
    public ArrayList<DisciplinaCursada> getHistEscolar() {return histEscolar;}

    public void setMatrAluno(String matrAluno) {this.matrAluno = matrAluno;}
    public void setNomePessoa(String nomePessoa) {this.nomePessoa = nomePessoa;}
    public void setPercentAprovTotal(Double percentAprovTotal) {this.percentAprovTotal = percentAprovTotal;}
    public void setPercentAprovAtual(Double percentAprovAtual) {this.percentAprovAtual = percentAprovAtual;}
    public void setIra(Double ira) {this.ira = ira;}
    public void setReprovTotal(int reprovTotal) {this.reprovTotal = reprovTotal;}
    public void setReprovNotaTotal(int reprovNotaTotal) {this.reprovNotaTotal = reprovNotaTotal;}
    public void setReprovFaltaTotal(int reprovFaltaTotal) {this.reprovFaltaTotal = reprovFaltaTotal;}
    public void setReprovAtual(int reprovAtual) {this.reprovAtual = reprovAtual;}
    public void setReprovNotaAtual(int reprovNotaAtual) {this.reprovNotaAtual = reprovNotaAtual;}
    public void setReprovFaltaAtual(int reprovFaltaAtual) {this.reprovFaltaAtual = reprovFaltaAtual;}
    public void setPeriodoAtual(int periodoAtual) {this.periodoAtual = periodoAtual;}
    public void setHistEscolar(ArrayList<DisciplinaCursada> histEscolar) {this.histEscolar = histEscolar;}

    public void printAluno()
    {
        System.out.println("---------------------------");
        System.out.println("codCurso = " + matrAluno);
        System.out.println("numVer = " + nomePessoa);
        System.out.println("IRA atual = " + String.format("%.06f", ira / 100) + "%");
        System.out.println("porcentagem de aprovacao total = " + String.format("%.02f", percentAprovTotal * 100) + "%");
        System.out.println("numero de reprovacoes total = " + reprovTotal);
        System.out.println("porcentagem de aprovacao atual = " + String.format("%.02f", percentAprovAtual * 100) + "%");
        System.out.println("numero de reprovacoes atuais = " + reprovAtual);
        for(DisciplinaCursada x : histEscolar)
        {
            x.printDiscCursada();
        }
    }
}