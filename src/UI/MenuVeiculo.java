package UI;

import java.util.Scanner;
import service.VeiculoService;
import exception.EntidadeJaExisteException;
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
            System.out.println("\n=== Cadastro de veiculo ===");

            System.out.print("Chassi: ");
            String chassi = scanner.nextLine();

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

            try {
                veiculoService.cadastrar(chassi, nome, cor, numMarcha, numPortas, marca, ano);
                System.out.println("Cadastro de veiculo concluido!");

                String resposta;

                do {
                    System.out.print("\nDeseja cadastrar outro veiculo? (s/n): ");
                    resposta = scanner.nextLine().toLowerCase();
                    if (!resposta.equals("s") && !resposta.equals("n")) {
                        System.out.println("Resposta invalida");
                    }
                } while (!resposta.equals("s") && !resposta.equals("n"));

                continuarCadastro = resposta.equals("s");
            } catch (EntidadeJaExisteException e) {
                System.out.println("Erro: " + e.getMessage());
                continuarCadastro = false;
            }
        } while (continuarCadastro);
    }

    @Override
    public void consultar() {
        boolean continuarConsulta = true;

        do {
            System.out.println("\n=== Consultar Veiculo ===");
            System.out.print("Digite o chassi do veiculo: ");
            String chassi = scanner.nextLine();

            Veiculo veiculo = veiculoService.consultar(chassi);

            if (veiculo != null) {
                System.out.println("Veiculo encontrado:");
                System.out.println(veiculo);
            } else {
                System.out.println("Veiculo não encontrado.");
            }

            String resposta;
            do {
                System.out.print("\nDeseja consultar outro veiculo? (s/n): ");
                resposta = scanner.nextLine().toLowerCase();

                if (!resposta.equals("s") && !resposta.equals("n")) {
                    System.out.println("Resposta invalida");
                }
            } while (!resposta.equals("s") && !resposta.equals("n"));

            continuarConsulta = resposta.equals("s");

        } while (continuarConsulta);

        System.out.println("Voltando ao menu principal...");
    }

    @Override
    public void alterar() {
        boolean continuarAlteracao = true;
        int opcao;

        while (continuarAlteracao) {
            System.out.println("\n=== Alteracao de Veiculo ===");
            System.out.println("O que deseja alterar: ");
            System.out.println("[1] - Chassi");
            System.out.println("[2] - Nome");
            System.out.println("[3] - Cor");
            System.out.println("[4] - Numero de marchas");
            System.out.println("[5] - Numero de portas");
            System.out.println("[6] - Marca");
            System.out.println("[7] - Ano");
            System.out.println("[8] - Voltar ao menu principal");
            System.out.println("[9] - Sair");
            System.out.print("R: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1 -> veiculoService.alterarChassi();
                case 2 -> veiculoService.alterarNome();
                case 3 -> veiculoService.alterarCor();
                case 4 -> veiculoService.alterarNumMarcha();
                case 5 -> veiculoService.alterarNumPorta();
                case 6 -> veiculoService.alterarMarca();
                case 7 -> veiculoService.alterarAno();
                case 8 -> continuarAlteracao = false;
                case 9 -> System.exit(0);
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    public void remover() {
        boolean continuarRemocao = true;

        do {
            System.out.println("\n=== Remocao de Veiculo ===");
            System.out.print("Digite o chassi do veiculo que deseja remover: ");

            String chassiVeiculo = scanner.nextLine();
            Veiculo veiculo = veiculoService.consultar(chassiVeiculo);

            if (veiculo != null) {
                System.out.println("Veiculo encontrado!");
                veiculoService.remover(veiculo);
                System.out.println("Veiculo removido com sucesso!");
            } else {
                System.out.println("Veiculo nao encontrado.");
            }

            String resposta;
            do {
                System.out.print("\nDeseja remover outro veiculo? (s/n): ");
                resposta = scanner.nextLine().toLowerCase();

                if (!resposta.equals("s") && !resposta.equals("n")) {
                    System.out.println("Resposta invalida");
                }
            } while (!resposta.equals("s") && !resposta.equals("n"));

            continuarRemocao = resposta.equals("s");

        } while (continuarRemocao);

        System.out.println("Voltando ao menu principal...");
    }
    public void relatorio() {
        System.out.println("\n=== RELATORIO DE VEICULOS ===");
        veiculoService.relatorio();
    }
}
