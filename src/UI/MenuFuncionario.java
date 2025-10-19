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

            if (!resposta.equals("s")) {
                continuarCadastro = false;
            }
            if (!resposta.equals("n")) {
                continuarCadastro = true;
            }
            if (!resposta.equals("s") && !resposta.equals("n")) {
                while(!resposta.equals("s") && !resposta.equals("n")) {
                    
                    System.out.println("Resposta invalida");
                    System.out.print("\nDeseja cadastrar outro funcionario? (s/n): ");
                    resposta = scanner.nextLine().toLowerCase();
                    
                }
            }
        } while(continuarCadastro);

        System.out.println("Voltando ao menu principal...");
    }

    @Override
    public void consultar() {
        System.out.println("=== Consultar Funcionario ===");
        System.out.print("Digite o numero de matricula: ");
        int numMatricula = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = funcionarioService.buscaPorMatricula(numMatricula);

        if (funcionario != null) {
            System.out.println("\n--- Funcionario Encontrado ---");
            System.out.println(funcionario);
        } else {
            System.out.println("Funcionario nao encontrado!");
        }
    }

    
    @Override
    public void alterar() {
        boolean continuarAlteracao = true;
        int opcao;
        while(continuarAlteracao) {
            
            System.out.println("--- Alteracao de Funcionario ---");
            System.out.println("O que deseja alterar: ");
            System.out.println("[1] - Nome");
            System.out.println("[2] - Numero de matricula");
            System.out.println("[3] - Qualificacao");
            System.out.println("[4] - Descricao de funcao");
            System.out.println("[5] - Carga horaria");
            System.out.println("[6] - Voltar ao menu principal");
            System.out.println("[7] - Sair");
            opcao = scanner.nextInt();
        
            switch(opcao) {
                case 1 -> funcionarioService.alterarNome();
                case 2 -> funcionarioService.alterarNumMatricula();
                case 3 -> funcionarioService.alterarQualificacao();
                case 4 -> funcionarioService.alterarDescricaoFuncao();
                case 5 -> funcionarioService.alterarCargaHoraria();
                case 6 -> continuarAlteracao = false;
                case 7 -> System.exit(0);
        
        
    }
        }
    
}
}
