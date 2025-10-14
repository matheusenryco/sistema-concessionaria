package model;

public class Funcionario extends Pessoa {
    private int numMatricula;
    private String qualificacao;
    private String descricaoFuncao;
    private int cargaHorariaSemanal;

    public Funcionario(String nome, int numMatricula, String qualificacao,String descricaoFuncao, int cargaHorariaSemanal) {
        super(nome);
        this.numMatricula = numMatricula;
        this.qualificacao = qualificacao;
        this.descricaoFuncao = descricaoFuncao;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public int getNumMatricula() { return numMatricula; }

    public void setNumMatricula(int numMatricula) { this.numMatricula = numMatricula; }

    public String getQualificacao() { return qualificacao; }

    public void setQualificacao(String qualificacao) { this.qualificacao = qualificacao; }

    public String getDescricaoFuncao() { return descricaoFuncao; }

    public void setDescricaoFuncao(String descricaoFuncao) { this.descricaoFuncao = descricaoFuncao; }

    public int getCargaHorariaSemanal() { return cargaHorariaSemanal; }

    public void setCargaHorariaSemanal(int cargaHorariaSemanal) { this.cargaHorariaSemanal = cargaHorariaSemanal; }

    @Override
    public String toString() {
        return "Nome: " + getNome() +
                ", Matrícula: " + numMatricula +
                ", Qualificação: " + qualificacao +
                ", Descrição da Função: " + descricaoFuncao +
                ", Carga Horária Semanal: " + cargaHorariaSemanal + " horas";
    }
}