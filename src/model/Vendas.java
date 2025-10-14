package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vendas {
    private LocalDateTime data;
    private double valor;
    private Cliente cliente;
    private Funcionario funcionario;
    private Veiculo veiculo;

    public Vendas(LocalDateTime data, double valor, Cliente cliente, Funcionario funcionario, Veiculo veiculo) {
        this.data = data;
        this.valor = valor;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.veiculo = veiculo;
    }

    public LocalDateTime getData() { return data; }

    public void setData(LocalDateTime data) { this.data = data; }

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
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(fmt);
        return "Vendas: " +
                "\n Data: " + dataFormatada +
                "\n Valor: " + valor +
                "\n Cliente: " + cliente +
                "\n Funcionario: " + funcionario +
                "\n veiculo: " + veiculo;
    }
}