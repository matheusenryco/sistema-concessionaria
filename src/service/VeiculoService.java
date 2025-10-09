
package service;

import model.Veiculo;

import java.util.List;
import java.util.ArrayList;

public class VeiculoService {
    private final List<Veiculo> veiculos;
    
    
    public VeiculoService() {
        this.veiculos = new ArrayList<>();
        
        
        
    }
    
    public void cadastrar(String nome, String cor, int numMarcha, int numPorta, String marca, int ano) {
        Veiculo veiculo = new Veiculo(nome, cor, numMarcha, numPorta, marca, ano);
        veiculos.add(veiculo);
        
    }
    
    
    
}
