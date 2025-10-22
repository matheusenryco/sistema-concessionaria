package model;

public class Veiculo {
    private String chassi;
    private String nome;
    private String cor;
    private int numMarchas;
    private int numPortas;
    private String marca;
    private int ano;

    public Veiculo(String chassi, String nome, String cor, int numMarchas, int numPortas, String marca, int ano) {
        this.chassi = chassi;
        this.nome = nome;
        this.cor = cor;
        this.numMarchas = numMarchas;
        this.numPortas = numPortas;
        this.marca = marca;
        this.ano = ano;
    }

    public String getChassi() { return chassi; }

    public void setChassi(String chassi) { this.chassi = chassi; }

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
        return "Chassi: " + chassi + "\n" +
                "Nome: " + nome + "\n" +
                "Cor: " + cor + "\n" +
                "Numero de Marchas: " + numMarchas + "\n" +
                "Numero de Portas: " + numPortas + "\n" +
                "Marca: " + marca + "\n" +
                "Ano: " + ano;
    }
}
