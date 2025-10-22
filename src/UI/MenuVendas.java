package UI;

import model.Vendas;
import model.Cliente;
import model.Veiculo;
import model.Funcionario;
import service.VeiculoService;
import service.ClienteService;
import service.FuncionarioService;
import service.VendasService;
import java.util.Scanner;

public class MenuVendas implements IMenu {
    private final Scanner scanner;
    private final ClienteService clienteService;
    private final FuncionarioService funcionarioService;
    private final VeiculoService veiculoService;
    private final VendasService vendasService;

    public MenuVendas(ClienteService clienteService, FuncionarioService funcionarioService, VeiculoService veiculoService, VendasService vendasService) {
        this.scanner = new Scanner(System.in);
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
        this.veiculoService = veiculoService;
        this.vendasService = vendasService;
    }

    @Override
    public void cadastrar() {
        boolean continuarCadastro = true;

        do {
            System.out.println("\n=== Cadastro de Vendas ===");

            System.out.print("Data da venda: ");
            String data = scanner.nextLine();

            System.out.print("Valor da venda: R$ ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("CPF do cliente: ");
            String cpf = scanner.nextLine();
            Cliente cliente = clienteService.buscaPorCpf(cpf);

            System.out.print("Matricula do funcionario: ");
            int matricula = scanner.nextInt();
            scanner.nextLine();
            Funcionario funcionario = funcionarioService.buscaPorMatricula(matricula);

            System.out.print("Chassi do veiculo: ");
            String chassi = scanner.nextLine();
            Veiculo veiculo = veiculoService.consultar(chassi);

            if (cliente != null && funcionario != null && veiculo != null) {
                vendasService.cadastrar(data, valor, cliente, funcionario, veiculo);
                System.out.println("Venda cadastrada com sucesso!");

                System.out.print("\nDeseja cadastrar outra venda? (s/n): ");
                String resposta = scanner.nextLine().toLowerCase();

                while (!resposta.equals("s") && !resposta.equals("n")) {
                    System.out.println("Resposta invalida! Digite 's' ou 'n'.");
                    System.out.print("Deseja cadastrar outra venda? (s/n): ");
                    resposta = scanner.nextLine().toLowerCase();
                }

                continuarCadastro = resposta.equals("s");
            } else {
                System.out.println("Erro: Verifique se cliente, funcionario e veiculo existem!");
                continuarCadastro = false;
            }
        } while (continuarCadastro);
    }

    @Override
    public void consultar() {
        boolean continuarConsulta = true;

        do {
            System.out.println("\n=== Consulta de Vendas ===");
            System.out.println("Consultar por:");
            System.out.println("[1] - Cliente");
            System.out.println("[2] - Funcionario");
            System.out.println("[3] - Veiculo");
            System.out.print("R: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    Cliente cliente = clienteService.buscaPorCpf(cpf);
                    Vendas venda = (cliente != null) ? vendasService.consultarPorCliente(cliente) : null;

                    if (venda != null) {
                        System.out.println("Venda encontrada:");
                        System.out.println(venda);
                    } else {
                        System.out.println("Venda nao encontrada.");
                    }
                }

                case 2 -> {
                    System.out.print("Digite a matricula do funcionario: ");
                    int matricula = scanner.nextInt();
                    scanner.nextLine();
                    Funcionario funcionario = funcionarioService.buscaPorMatricula(matricula);
                    Vendas venda = (funcionario != null) ? vendasService.consultarPorFuncionario(funcionario) : null;

                    if (venda != null) {
                        System.out.println("Venda encontrada:");
                        System.out.println(venda);
                    } else {
                        System.out.println("Venda nao encontrada.");
                    }
                }

                case 3 -> {
                    System.out.print("Digite o chassi do veiculo: ");
                    String chassi = scanner.nextLine();
                    Veiculo veiculo = veiculoService.consultar(chassi);
                    Vendas venda = (veiculo != null) ? vendasService.consultarPorVeiculo(veiculo) : null;

                    if (venda != null) {
                        System.out.println("Venda encontrada:");
                        System.out.println(venda);
                    } else {
                        System.out.println("Venda nao encontrada.");
                    }
                }

                default -> System.out.println("Opcao invalida!");
            }

            System.out.print("\nDeseja consultar outra venda? (s/n): ");
            String resposta = scanner.nextLine().toLowerCase();

            while (!resposta.equals("s") && !resposta.equals("n")) {
                System.out.println("Resposta invalida! Digite 's' ou 'n'.");
                System.out.print("Deseja consultar outra venda? (s/n): ");
                resposta = scanner.nextLine().toLowerCase();
            }

            continuarConsulta = resposta.equals("s");

        } while (continuarConsulta);

        System.out.println("Voltando ao menu principal...");
    }

    @Override
    public void alterar() {
        boolean continuarAlteracao = true;
        int opcao;

        while (continuarAlteracao) {
            System.out.println("\n=== Alteracao de Vendas ===");
            System.out.println("O que deseja alterar: ");
            System.out.println("[1] - Data");
            System.out.println("[2] - Valor");
            System.out.println("[3] - Cliente");
            System.out.println("[4] - Funcionario");
            System.out.println("[5] - Veiculo");
            System.out.println("[6] - Voltar ao menu principal");
            System.out.println("[7] - Sair");
            System.out.print("R: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> vendasService.alterarData();
                case 2 -> vendasService.alterarValor();
                case 3 -> vendasService.alterarCliente();
                case 4 -> vendasService.alterarFuncionario();
                case 5 -> vendasService.alterarVeiculo();
                case 6 -> continuarAlteracao = false;
                case 7 -> System.exit(0);
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    @Override
    public void remover() {
        boolean continuarRemocao = true;

        do {
            System.out.println("\n=== Remocao de Vendas ===");
            System.out.print("Digite o chassi do veiculo da venda que deseja remover: ");
            String chassi = scanner.nextLine();

            Veiculo veiculo = veiculoService.consultar(chassi);
            Vendas venda = (veiculo != null) ? vendasService.consultarPorVeiculo(veiculo) : null;

            if (venda != null) {
                vendasService.remover(venda);
                System.out.println("Venda removida com sucesso!");
            } else {
                System.out.println("Venda nao encontrada.");
            }

            System.out.print("\nDeseja remover outra venda? (s/n): ");
            String resposta = scanner.nextLine().toLowerCase();


            while (!resposta.equals("s") && !resposta.equals("n")) {
                System.out.println("Resposta invalida! Digite 's' ou 'n'.");
                System.out.print("Deseja remover outra venda? (s/n): ");
                resposta = scanner.nextLine().toLowerCase();
            }

        } while (continuarRemocao);

        System.out.println("Voltando ao menu principal...");
    }
    public void relatorio() {
        System.out.println("\n=== RELATORIO DE VENDAS ===");
        vendasService.relatorio();
    }
}