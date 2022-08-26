package Source.MVC.Model.Disciplina;

public class Disciplina
{
    private String codCurso;
    private String numVer;
    private String descEstru;
    private String codDisciplina;
    private String nomeUnidade;
    private String nomeDisciplina;
    private String periodoIdeal;
    private String numHoras;
    private String tipoDisciplina;
    private String chTotal;
    private String descSituacao;

    /* Constructor */
    public Disciplina(){}

    /* Get and Set */
    public String getCodCurso() {return codCurso;}
    public String getNumVer() {return numVer;}
    public String getDescEstru() {return descEstru;}
    public String getCodDisciplina() {return codDisciplina;}
    public String getNomeUnidade() {return nomeUnidade;}
    public String getNomeDisciplina() {return nomeDisciplina;}
    public String getPeriodoIdeal() {return periodoIdeal;}
    public String getNumHoras() {return numHoras;}
    public String getTipoDisciplina() {return tipoDisciplina;}
    public String getCHTotal() {return chTotal;}
    public String getDescSituacao() {return descSituacao;}

    public void setCodCurso(String codCurso) {this.codCurso = codCurso;}
    public void setNumVer(String numVer) {this.numVer = numVer;}
    public void setDescEstru(String descEstru) {this.descEstru = descEstru;}
    public void setCodDisciplina(String codDisciplina) {this.codDisciplina = codDisciplina;}
    public void setNomeUnidade(String nomeUnidade) {this.nomeUnidade = nomeUnidade;}
    public void setNomeDisciplina(String nomeDisciplina) {this.nomeDisciplina = nomeDisciplina;}
    public void setPeriodoIdeal(String periodoIdeal) {this.periodoIdeal = periodoIdeal;}
    public void setNumHoras(String numHoras) {this.numHoras = numHoras;}
    public void setTipoDisciplina(String tipoDisciplina) {this.tipoDisciplina = tipoDisciplina;}
    public void setCHTotal(String cHTotal) {this.chTotal = cHTotal;}
    public void setDescSituacao(String descSituacao) {this.descSituacao = descSituacao;}

    /* Debug Func */
    public void printDisc()
    {
        System.out.println("---------------------------");
        System.out.println("codCurso = " + codCurso);
        System.out.println("numVer = " + numVer);
        System.out.println("descEstru = " + descEstru);
        System.out.println("codDisciplina = " + codDisciplina);
        System.out.println("nomeUnidade = " + nomeUnidade);
        System.out.println("nomeDisciplina = " + nomeDisciplina);
        System.out.println("periodoIdeal = " + periodoIdeal);
        System.out.println("numHoras = " + numHoras);
        System.out.println("tipoDisciplina = " + tipoDisciplina);
        System.out.println("chTotal = " + chTotal);
        System.out.println("descSituacao = " + descSituacao);
    }

}
