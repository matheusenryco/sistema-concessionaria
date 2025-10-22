package model;

import java.util.Locale;

public class Vendas {
    private String data;
    private double valor;
    private Cliente cliente;
    private Funcionario funcionario;
    private Veiculo veiculo;

    public Vendas(String data, double valor, Cliente cliente, Funcionario funcionario, Veiculo veiculo) {
        this.data = data;
        this.valor = valor;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.veiculo = veiculo;
    }

    public String getData() { return data; }

    public void setData(String data) { this.data = data; }

    public double getValor() { return valor; }

    public void setValor(double valor) { this.valor = valor; }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Funcionario getFuncionario() { return funcionario;}

    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }

    public Veiculo getVeiculo() { return veiculo; }

    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }

    @Override
    public String toString() {
        return "=== VENDA ===\n" +
                "Data: " + data + "\n" +
                "Valor: R$ " + String.format("%.2f", valor) +
                "\n\n=== CLIENTE ===\n" +
                "Cliente:" + cliente + "\n" +
                "\n\n=== FUNCIONARIO ===\n" +
                "Funcionario: " + funcionario + "\n" +
                "\n\n=== VEICULO ===\n" +
                "Veiculo: " + veiculo;
    }
}