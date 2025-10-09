
package service;

import model.Funcionario;
import java.util.List;
import java.util.ArrayList;

public class FuncionarioService {
    private final List<Funcionario> funcionarios;
    
    
    public FuncionarioService() {
        this.funcionarios = new ArrayList<>();
        
        
        
    }
    
    public void cadastrar(String nome, int numMatricula, String qualificacao, String funcao, int cargaHoraria) {
        Funcionario funcionario = new Funcionario(nome,numMatricula, qualificacao, funcao, cargaHoraria); 
        funcionarios.add(funcionario);
    }
}
