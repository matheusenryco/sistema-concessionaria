package UI;

import service.ClienteService;
import service.FuncionarioService;
import service.VeiculoService;
import UI.MenuCliente;
import java.util.Scanner;

public class MenuPrincipal {
    private final Scanner scanner;
    private final MenuCliente menuCliente;
    private final MenuFuncionario menuFuncionario;
    private final MenuVeiculo menuVeiculo;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        this.menuCliente = new MenuCliente(clienteService);
        FuncionarioService funcionarioService = new FuncionarioService();
        this.menuFuncionario = new MenuFuncionario(funcionarioService);
        VeiculoService veiculoService = new VeiculoService();
        this.menuVeiculo = new MenuVeiculo(veiculoService);
    }

    public void iniciarSistema() {
        boolean executando = true;
        int opcao;

        while (executando) {
            System.out.println("\n[1] - Cadastrar");
            System.out.println("[2] - Consultar");
            System.out.println("[3] - Alterar");
            System.out.println("[4] - Remover");
            System.out.println("[5] - Sair");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> menuCadastro();
                    case 2 -> menuConsulta();
                    case 3 -> menuAlteracao();
                    // case 4 -> menuRemocao();
                    case 5 -> {
                        executando = false;
                        System.out.println("\nEncerrando sistema...");
                    }
                    default -> System.out.println("Opcao invalida!");
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida! Digite apenas numeros.");
                scanner.nextLine();
            }
        }
    }

    private void menuCadastro() {
        boolean executando = true;
        int opcao;

        while (executando) {
            System.out.println("\n=======================================");
            System.out.println("\t\t\tCADASTRO");
            System.out.println("=======================================");
            System.out.println("[1] - Cliente");
            System.out.println("[2] - Funcionario");
            System.out.println("[3] - Veiculo");
            System.out.println("[4] - Vendas");
            System.out.println("[5] - Retornar ao menu principal");
            System.out.println("[6] - Sair");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> menuCliente.cadastrar();
                    case 2 -> menuFuncionario.cadastrar();
                    case 3 -> menuVeiculo.cadastrar();
                    // case 4 -> menuVendas.cadastrar();
                    case 5 -> executando = false;
                    case 6 -> System.exit(0);
                    default -> System.out.println("Opcao invalida!");
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida! Digite apenas numeros.");
                scanner.nextLine();
            }
        }
    }

    private void menuConsulta() {
        boolean executando = true;
        int opcao;

        while (executando) {
            System.out.println("\n=======================================");
            System.out.println("\t\t\tCONSULTA");
            System.out.println("=======================================");
            System.out.println("[1] - Cliente");
            System.out.println("[2] - Funcionario");
            System.out.println("[3] - Veiculo");
            System.out.println("[4] - Vendas");
            System.out.println("[5] - Retornar ao menu principal");
            System.out.println("[6] - Sair");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> menuCliente.consultar();
                    case 2 -> menuFuncionario.consultar();
                    case 3 -> menuVeiculo.consultar();
                    // case 4 -> menuVendas.cadastrar();
                    case 5 -> executando = false;
                    case 6 -> System.exit(0);
                    default -> System.out.println("Opcao invalida!");
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida! Digite apenas numeros.");
                scanner.nextLine();
            }
        }
    }

    private void menuAlteracao() {
        boolean continuarAlteracao = true;
        int opcao;

        while (continuarAlteracao) {
            System.out.println("\n=======================================");
            System.out.println("ALTERAR");
            System.out.println("\n=======================================");
            System.out.println("O que deseja alterar: ");
            System.out.println("[1] - Cliente");
            System.out.println("[2] - Funcionario");
            System.out.println("[3] - Veiculo");
            System.out.println("[4] - Vendas");
            System.out.println("[5] - Retornar ao menu principal");
            System.out.println("[6] - Sair");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> menuCliente.alterar();
                    case 2 -> menuFuncionario.alterar();
                    case 3 -> menuVeiculo.alterar();
                    case 5 -> continuarAlteracao = false;
                    default -> System.out.println("Opcao invalida!");
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida, digite apenas numeros");
                scanner.nextLine();
            }
        }
    }
}