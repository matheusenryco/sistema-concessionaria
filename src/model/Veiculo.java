package model;

public class Veiculo {
    private String nome;
    private String cor;
    private int numMarchas;
    private int numPortas;
    private String marca;
    private int ano;

    public Veiculo(String nome, String cor, int numMarchas, int numPortas, String marca, int ano) {
        this.nome = nome;
        this.cor = cor;
        this.numMarchas = numMarchas;
        this.numPortas = numPortas;
        this.marca = marca;
        this.ano = ano;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCor() { return cor; }

    public void setCor(String cor) { this.cor = cor; }

    public int getNumMarchas() { return numMarchas; }

    public void setNumMarchas(int numMarchas) { this.numMarchas = numMarchas; }

    public int getNumPortas() { return numPortas; }

    public void setNumPortas(int numPortas) { this.numPortas = numPortas; }

    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public int getAno() { return ano; }

    public void setAno(int ano) { this.ano = ano; }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\n or: " + cor +
                "\n Número de Marchas: " + numMarchas +
                "\n Número de Portas: " + numPortas +
                "\n Marca: " + marca +
                "\n Ano: " + ano;
    }
}
