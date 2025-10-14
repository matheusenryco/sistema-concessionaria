package UI;

import model.Funcionario;
import service.FuncionarioService;
import java.util.Scanner;

public class MenuFuncionario implements IMenu {
    private final Scanner scanner;
    private final FuncionarioService funcionarioService;

    public MenuFuncionario(FuncionarioService funcionarioService) {
        this.scanner = new Scanner(System.in);
        this.funcionarioService = funcionarioService;
    }

    @Override
    public void cadastrar() {
        boolean continuarCadastro = true;

        do{
            System.out.println("=== Cadastro de funcionario ===");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Numero de matricula: ");
            int numMatricula = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Qualificacao: ");
            String qualificacao = scanner.nextLine();

            System.out.print("Descricao de funcao: ");
            String funcao = scanner.nextLine();

            System.out.print("Carga horaria semanal: ");
            int cargaHoraria = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Funcionario cadastrado com sucesso");

            System.out.print("\nDeseja continuar cadastro? (s/n): ");
            String resposta = scanner.nextLine().toLowerCase();

            funcionarioService.cadastrar(nome, numMatricula, qualificacao, funcao, cargaHoraria);

            if (!resposta.equals("s")){
                continuarCadastro = false;
            }
        } while(continuarCadastro);

        System.out.println("Voltando ao menu principal...");
    }

    @Override
    public void consultar() {
        System.out.println("=== Consultar Funcionário ===");
        System.out.print("Digite o número de matrícula: ");
        int numMatricula = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = funcionarioService.buscaPorMatricula(numMatricula);

        if (funcionario != null) {
            System.out.println("\n--- Funcionário Encontrado ---");
            System.out.println(funcionario);
        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

    /*
    @Override
    public void alterar() {
        // TODO: Implementar alteração de cliente
    }
    */
}