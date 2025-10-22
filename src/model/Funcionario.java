package model;

public class Funcionario {
    private String nome;
    private int numMatricula;
    private String qualificacao;
    private String descricaoFuncao;
    private int cargaHorariaSemanal;

    public Funcionario(String nome, int numMatricula, String qualificacao,String descricaoFuncao, int cargaHorariaSemanal) {
        this.nome = nome;
        this.numMatricula = numMatricula;
        this.qualificacao = qualificacao;
        this.descricaoFuncao = descricaoFuncao;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

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
        return "Nome: " + nome +
                "\nMatricula: " + numMatricula +
                "\nQualificacao: " + qualificacao +
                "\nDescricao da Funcao: " + descricaoFuncao +
                "\nCarga Horaria Semanal: " + cargaHorariaSemanal + " horas";
    }
}