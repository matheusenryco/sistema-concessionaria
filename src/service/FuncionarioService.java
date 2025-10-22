package service;

import model.Funcionario;
import exception.EntidadeJaExisteException;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class FuncionarioService {
    private final Set<Funcionario> funcionarios;
    private final Scanner scanner;

    public FuncionarioService() {
        this.funcionarios = new HashSet<>();
        this.scanner = new Scanner(System.in);
    }

    public void cadastrar(String nome, int numMatricula, String qualificacao, String funcao, int cargaHoraria) {
        if (buscaPorMatricula(numMatricula) != null) {
            throw new EntidadeJaExisteException("Ja existe um funcionario com a matricula: " + numMatricula);
        }
        Funcionario funcionario = new Funcionario(nome, numMatricula, qualificacao, funcao, cargaHoraria);
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
        System.out.println("=== ALTERAR NOME ===");
        System.out.print("Digite o numero de matricula do funcionario: ");
        int numMatricula = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = buscaPorMatricula(numMatricula);

        if (funcionario != null) {
            System.out.println("Funcionario encontrado");
            System.out.print("Digite o novo nome: ");

            String novoNome = scanner.nextLine();
            funcionario.setNome(novoNome);

            System.out.println("Nome alterado com sucesso");
        } else {
            System.out.println("Funcionario nao encontrado.");
        }
    }

    public void alterarNumMatricula() {
        System.out.println("=== ALTERAR MATRICULA ===");
        System.out.print("Digite o numero de matricula do funcionario: ");
        int numMatricula = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = buscaPorMatricula(numMatricula);

        if (funcionario != null) {
            System.out.println("Funcionario encontrado");
            System.out.print("Digite o novo numero de matricula: ");

            int novoNumMatricula = scanner.nextInt();
            funcionario.setNumMatricula(novoNumMatricula);

            System.out.println("Matricula alterada com sucesso");
        } else {
            System.out.println("Funcionario nao encontrado.");
        }
    }

    public void alterarQualificacao() {
        System.out.println("=== ALTERAR QUALIFICACAO ===");
        System.out.print("Digite o numero de matricula do funcionario: ");
        int numMatricula = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = buscaPorMatricula(numMatricula);

        if (funcionario != null) {
            System.out.println("Funcionario encontrado");
            System.out.print("Digite a nova qualificacao: ");

            String novaQualificacao = scanner.nextLine();
            funcionario.setQualificacao(novaQualificacao);

            System.out.println("Qualificacao alterada com sucesso");
        } else {
            System.out.println("Funcionario nao encontrado.");
        }
    }

    public void alterarDescricaoFuncao() {
        System.out.println("=== ALTERAR DESCRICAO DE FUNCAO ===");
        System.out.print("Digite o numero de matricula do funcionario: ");
        int numMatricula = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = buscaPorMatricula(numMatricula);

        if (funcionario != null) {
            System.out.println("Funcionario encontrado");
            System.out.print("Digite a nova descricao de funcao: ");

            String novaDescricao = scanner.nextLine();
            funcionario.setDescricaoFuncao(novaDescricao);

            System.out.println("Descricao alterada com sucesso");
        } else {
            System.out.println("Funcionario nao encontrado.");
        }
    }

    public void alterarCargaHoraria() {
        System.out.println("=== ALTERAR CARGA HORARIA SEMANAL ===");
        System.out.print("Digite o numero de matricula do funcionario: ");
        int numMatricula = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = buscaPorMatricula(numMatricula);

        if (funcionario != null) {
            System.out.println("Funcionario encontrado");
            System.out.print("Digite a nova carga horaria: ");

            int novaCargaHoraria = scanner.nextInt();
            funcionario.setCargaHorariaSemanal(novaCargaHoraria);

            System.out.println("Carga horaria alterada com sucesso");
        } else {
            System.out.println("Funcionario nao encontrado.");
        }
    }

    public void remover(Funcionario funcionario){
        funcionarios.remove(funcionario);
        System.out.println("Funcionario removido com sucesso");
    }
    public void relatorio() {
        int cont = 0;

        for (Funcionario funcionario : funcionarios) {
            cont += 1;

            System.out.println("-------------");
            System.out.println(" Funcionario : " + cont);
            System.out.println("-------------");
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Matricula: " + funcionario.getNumMatricula());
            System.out.println("Qualificacao: " + funcionario.getQualificacao());
            System.out.println("Funcao: " + funcionario.getDescricaoFuncao());
            System.out.println("Carga Horaria: " + funcionario.getCargaHorariaSemanal());
            System.out.println("");
        }
    }
}
