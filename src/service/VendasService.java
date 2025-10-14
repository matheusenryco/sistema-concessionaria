// TEM QUE PENSAR MELHOR NESSE VENDAS

package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import model.Vendas;
import model.Cliente;
import model.Funcionario;
import model.Veiculo;

import java.util.HashSet;
import java.util.Set;

public class VendasService {
   private final Set<Vendas> vendas = new HashSet();
    
    public void cadastrar(String data, double valor, Cliente cliente, Funcionario funcionario, Veiculo veiculo){
        Vendas venda = new Vendas(data, valor, cliente, funcionario, veiculo);
        vendas.add(venda);
    }
    
    public Vendas consultar(Funcionario funcionario) {
        for (Vendas venda : vendas) {
            if (venda.getFuncionario().equals(funcionario)) {
                return venda;
            }
        }
        return null;
    }
}
