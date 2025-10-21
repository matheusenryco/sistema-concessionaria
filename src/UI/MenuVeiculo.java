package UI;

import java.util.Scanner;
import service.VeiculoService;
import model.Veiculo;

public class MenuVeiculo implements IMenu {
    private final Scanner scanner;
    private final VeiculoService veiculoService;

    public MenuVeiculo(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void cadastrar() {
        boolean continuarCadastro;

        do {
            System.out.println("=== Cadastro de veiculo ===");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Cor: ");
            String cor = scanner.nextLine();

            System.out.print("Numero de marcha: ");
            int numMarcha = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Numero de portas: ");
            int numPortas = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Marca: ");
            String marca = scanner.nextLine();

            System.out.print("Ano: ");
            int ano = scanner.nextInt();
            scanner.nextLine();

            veiculoService.cadastrar(nome, cor, numMarcha, numPortas, marca, ano);
            System.out.println("Cadastro de veiculo concluido");

            String resposta;
            do {
                System.out.print("\nDeseja cadastrar outro veiculo? (s/n): ");
                resposta = scanner.nextLine().toLowerCase();
                if (!resposta.equals("s") && !resposta.equals("n")) {
                    System.out.println("Resposta invalida");
                }
            } while (!resposta.equals("s") && !resposta.equals("n"));

            continuarCadastro = resposta.equals("s");
        } while (continuarCadastro);
    }

    @Override
    public void consultar() {
        System.out.println("=== Consultar Veículo ===");
        System.out.print("Digite o nome do veiculo: ");
        String nome = scanner.nextLine();

        var veiculo = veiculoService.consultar(nome);
        if (veiculo != null) {
            System.out.println("Veículo encontrado:");
            System.out.println(veiculo);
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    @Override
    public void alterar() {
        boolean continuarAlteracao = true;
        int opcao;

        while (continuarAlteracao) {
            System.out.println("=== Alteracao de Veiculo ===");
            System.out.println("O que deseja alterar: ");
            System.out.println("[1] - Nome");
            System.out.println("[2] - Cor");
            System.out.println("[3] - Numero de marchas");
            System.out.println("[4] - Numero de portas");
            System.out.println("[5] - Marca");
            System.out.println("[6] - Ano");
            System.out.println("[7] - Voltar ao menu principal");
            System.out.println("[8] - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1 -> veiculoService.alterarNome();
                case 2 -> veiculoService.alterarCor();
                case 3 -> veiculoService.alterarNumMarcha();
                case 4 -> veiculoService.alterarNumPorta();
                case 5 -> veiculoService.alterarMarca();
                case 6 -> veiculoService.alterarAno();
                case 7 -> continuarAlteracao = false;
                case 8 -> System.exit(0);
                default -> System.out.println("Opcao invalida!");
            }
        }
    }
    
    public void remover() {
        boolean continuarRemocao = true;
        while (continuarRemocao) {   
            System.out.println("Remocao de Veiculo");
            System.out.print("Digite o nome do veiculo que deseja remover: ");
            String nomeVeiculo = scanner.nextLine();          
            Veiculo veiculo = veiculoService.consultar(nomeVeiculo);
            if (veiculo != null) {
                System.out.println("Veiculo encontrado!");
                veiculoService.remover(veiculo); 
                continuarRemocao = false;
            }
            else {
                System.out.println("Veiculo nao encontrado");
            }     
        }
    }
}