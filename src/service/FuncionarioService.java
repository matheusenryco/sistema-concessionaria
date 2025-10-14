
package service;

import model.Cliente;
import model.Funcionario;
import java.util.HashSet;
import java.util.Set;

public class FuncionarioService {
    private final Set<Funcionario> funcionarios;

    public FuncionarioService() {
        this.funcionarios = new HashSet<>();
    }
    
    public void cadastrar(String nome, int numMatricula, String qualificacao, String funcao, int cargaHoraria) {
        Funcionario funcionario = new Funcionario(nome,numMatricula, qualificacao, funcao, cargaHoraria); 
        funcionarios.add(funcionario);
    }

    public Funcionario buscaPorMatricula(int numMatricula) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNumMatricula() == numMatricula) {
                return funcionario;
            }
        }
        return null;
    }
}
