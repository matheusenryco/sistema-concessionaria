
package service;

import model.Cliente;
import model.Funcionario;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

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
    
    public void alterarNome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- ALTERAR NOME ---");
        System.out.print("Digite o numero de matricula do funcionario: ");
        int numMatricula = scanner.nextInt();
        scanner.nextLine();
        
        Funcionario funcionario = buscaPorMatricula(numMatricula);
        
        if(funcionario != null) {
            System.out.println("Funcionario encontrado");
            System.out.println("Digite o novo nome: ");
            String novoNome = scanner.nextLine();
            funcionario.setNome(novoNome);
            System.out.println("Nome alterado com sucesso");
            System.out.println(funcionario);
            
    }
    }
    
    public void alterarNumMatricula() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- ALTERAR MATRICULA ---");
        System.out.print("Digite o numero de matricula do funcionario: ");
        int numMatricula = scanner.nextInt();
        scanner.nextLine();
        
        Funcionario funcionario = buscaPorMatricula(numMatricula);
        
        if(funcionario != null) {
            System.out.println("Funcionario encontrado");
            System.out.println("Digite o novo numero de matricula: ");
            int novoNumMatricula = scanner.nextInt();
            funcionario.setNumMatricula(novoNumMatricula);
            System.out.println("Matricula alterada com sucesso");
            System.out.println(funcionario);}
    }
    public void alterarQualificacao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- ALTERAR QUALIFICACAO ---");
        System.out.print("Digite o numero de matricula do funcionario: ");
        int numMatricula = scanner.nextInt();
        scanner.nextLine();
        
        Funcionario funcionario = buscaPorMatricula(numMatricula);
        
        if(funcionario != null) {
            System.out.println("Funcionario encontrado");
            System.out.println("Digite a nova qualificacao: ");
            String novoQualificacao = scanner.nextLine();
            funcionario.setQualificacao(novoQualificacao);
            System.out.println("Qualificacao alterada com sucesso");
            System.out.println(funcionario);}
    }
    
    public void alterarDescricaoFuncao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- ALTERAR DESCRICAO DE FUNCAO ---");
        System.out.print("Digite o numero de matricula do funcionario: ");
        int numMatricula = scanner.nextInt();
        scanner.nextLine();
        
        Funcionario funcionario = buscaPorMatricula(numMatricula);
        
        if(funcionario != null) {
            System.out.println("Funcionario encontrado");
            System.out.println("Digite a nova descricao de funcao: ");
            String novoDescricao = scanner.nextLine();
            funcionario.setDescricaoFuncao(novoDescricao);
            System.out.println("Descricao alterada com sucesso");
            System.out.println(funcionario);}
        
    }
    
    public void alterarCargaHoraria() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- ALTERAR CARGA HORARIA SEMANAL ---");
        System.out.print("Digite o numero de matricula do funcionario: ");
        int numMatricula = scanner.nextInt();
        scanner.nextLine();
        
        Funcionario funcionario = buscaPorMatricula(numMatricula);
        
        if(funcionario != null) {
            System.out.println("Funcionario encontrado");
            System.out.println("Digite a nova carga horaria");
            int novoCargaHoraria = scanner.nextInt();
            funcionario.setCargaHorariaSemanal(novoCargaHoraria);
            System.out.println("Carga horaria alterada com sucesso");
            System.out.println(funcionario);}
    }
}
