package service;

import model.Vendas;
import model.Cliente;
import model.Funcionario;
import model.Veiculo;

import java.util.HashSet;
import java.util.Set;

public class VendasService {
    private final Set<Vendas> vendas = new HashSet<>();

    public void cadastrar(String data, double valor, Cliente cliente, Funcionario funcionario, Veiculo veiculo){
        Vendas venda = new Vendas(data, valor, cliente, funcionario, veiculo);
        vendas.add(venda);
    }
    
    public Vendas consultarPorFuncionario(Funcionario funcionario) {
        for (Vendas venda : vendas) {
            if (venda.getFuncionario().equals(funcionario)) {
                return venda;
            }
        }
        return null;
    }

    public Vendas consultarPorCliente(Cliente cliente) {
        for (Vendas venda : vendas) {
            if (venda.getCliente().equals(cliente)) {
                return venda;
            }
        }
        return null;
    }

    public Vendas consultarPorVeiculo(Veiculo veiculo) {
        for (Vendas venda : vendas) {
            if (venda.getVeiculo().equals(veiculo)) {
                return venda;
            }
        }
        return null;
    }

    public void alterarData(Vendas venda, String novaData) {
        venda.setData(novaData);
    }

    public void alterarValor(Vendas venda, double novoValor) {
        venda.setValor(novoValor);
    }

    public void alterarCliente(Vendas venda, Cliente novoCliente) {
        venda.setCliente(novoCliente);
    }

    public void alterarFuncionario(Vendas venda, Funcionario novoFuncionario) {
        venda.setFuncionario(novoFuncionario);
    }

    public void alterarVeiculo(Vendas venda, Veiculo novoVeiculo) {
        venda.setVeiculo(novoVeiculo);
    }

    public boolean remover(Vendas venda) {
        return vendas.remove(venda);
    }
}
