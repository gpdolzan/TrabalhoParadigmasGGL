package MVC.Model.Disciplina;

public class DisciplinaCursada
{
    private String codCurso;
    private String nomeCurso;
    private String numVersao;
    private String ano;
    private String mediaFinal;
    private String situacaoItem;
    private String periodo;
    private String situacao;
    private String codAtivCurr;
    private String nomeAtivCurr;
    private String chTotal;
    private String descrEstru;
    private String frequencia;
    private String sigla;

    /* Constructor */
    public DisciplinaCursada(){}

    /* Get and Set */
    public String getCodCurso() {return codCurso;}
    public String getNomeCurso() {return nomeCurso;}
    public String getNumVersao() {return numVersao;}
    public String getAno() {return ano;}
    public String getMediaFinal() {return mediaFinal;}
    public String getSituacaoItem() {return situacaoItem;}
    public String getPeriodo() {return periodo;}
    public String getSituacao() {return situacao;}
    public String getCodAtivCurr() {return codAtivCurr;}
    public String getNomeAtivCurr() {return nomeAtivCurr;}
    public String getChTotal() {return chTotal;}
    public String getDescrEstru() {return descrEstru;}
    public String getFrequencia() {return frequencia;}
    public String getSigla() {return sigla;}

    public void setCodCurso(String codCurso) {this.codCurso = codCurso;}
    public void setNomeCurso(String nomeCurso) {this.nomeCurso = nomeCurso;}
    public void setNumVersao(String numVersao) {this.numVersao = numVersao;}
    public void setAno(String ano) {this.ano = ano;}
    public void setMediaFinal(String mediaFinal) {this.mediaFinal = mediaFinal;}
    public void setSituacaoItem(String situacaoItem) {this.situacaoItem = situacaoItem;}
    public void setPeriodo(String periodo) {this.periodo = periodo;}
    public void setSituacao(String situacao) {this.situacao = situacao;}
    public void setCodAtivCurr(String codAtivCurr) {this.codAtivCurr = codAtivCurr;}
    public void setNomeAtivCurr(String nomeAtivCurr) {this.nomeAtivCurr = nomeAtivCurr;}
    public void setChTotal(String chTotal) {this.chTotal = chTotal;}
    public void setDescrEstru(String descrEstru) {this.descrEstru = descrEstru;}
    public void setFrequencia(String frequencia) {this.frequencia = frequencia;}
    public void setSigla(String sigla) {this.sigla = sigla;}

    /* Debug Func */
    public void printDiscCursada()
    {
        System.out.println("---------------------------");
        System.out.println("codCurso = " + codCurso);
        System.out.println("nomeCurso = " + nomeCurso);
        System.out.println("numVersao = " + numVersao);
        System.out.println("ano = " + ano);
        System.out.println("mediaFinal = " + mediaFinal);
        System.out.println("situacaoItem = " + situacaoItem);
        System.out.println("periodo = " + periodo);
        System.out.println("situacao = " + situacao);
        System.out.println("codAtivCurr = " + codAtivCurr);
        System.out.println("nomeAtivCurr = " + nomeAtivCurr);
        System.out.println("chTotal = " + chTotal);
        System.out.println("descrEstru = " + descrEstru);
        System.out.println("frequencia = " + frequencia);
        System.out.println("sigla = " + sigla);
    }
}