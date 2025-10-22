package UI;

import model.Cliente;
import service.ClienteService;
import exception.EntidadeJaExisteException;
import java.util.Scanner;

public class MenuCliente implements IMenu {
    private final Scanner scanner;
    private final ClienteService clienteService;

    public MenuCliente(ClienteService clienteService) {
        this.scanner = new Scanner(System.in);
        this.clienteService = clienteService;
    }

    @Override
    public void cadastrar() {
        boolean continuarCadastro = true;

        do {
            System.out.println("=== Cadastro de Cliente ===");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("RG: ");
            String rg = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            try {
                clienteService.cadastrar(nome, telefone, email, rg, cpf);
                System.out.println("Cliente cadastrado com sucesso!");

                String resposta;
                do {
                    System.out.print("\nDeseja cadastrar outro cliente? (s/n): ");
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

        System.out.println("Voltando ao menu principal...");
    }

    @Override
    public void consultar() {
        boolean continuarConsulta = true;

        do {
            System.out.println("=== Consulta de Cliente ===");

            System.out.print("Digite o CPF do cliente: ");
            String cpf = scanner.nextLine();

            Cliente cliente = clienteService.buscaPorCpf(cpf);

            if (cliente != null) {
                System.out.println("Cliente encontrado:");
                System.out.print(cliente);
            } else {
                System.out.println("Cliente não encontrado.");
            }

            String resposta;
            do {
                System.out.print("\nDeseja consultar outro cliente? (s/n): ");
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
            System.out.println("=== Alteracao de Cliente ===");
            System.out.println("O que deseja alterar: ");
            System.out.println("[1] - Nome");
            System.out.println("[2] - Telefone");
            System.out.println("[3] - Email");
            System.out.println("[4] - RG");
            System.out.println("[5] - CPF");
            System.out.println("[6] - Voltar ao menu principal");
            System.out.println("[7] - Sair");
            System.out.print("R: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida! Digite apenas numeros.");
                continue;
            }

            switch (opcao) {
                case 1 -> clienteService.alterarNome();
                case 2 -> clienteService.alterarTelefone();
                case 3 -> clienteService.alterarEmail();
                case 4 -> clienteService.alterarRg();
                case 5 -> clienteService.alterarCpf();
                case 6 -> continuarAlteracao = false;
                case 7 -> System.exit(0);
                default -> System.out.println("Opcao invalida!");
            }
        }
    }
    
    public void remover() {
        boolean continuarRemocao = true;

        do {
            System.out.println("=== Remocao de Cliente ===");
            System.out.print("Digite o CPF do cliente que deseja remover: ");
            String cpf = scanner.nextLine();

            Cliente cliente = clienteService.buscaPorCpf(cpf);

            if (cliente != null) {
                System.out.println("Cliente encontrado!");
                clienteService.remover(cliente);
                System.out.println("Cliente removido com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
            }

            String resposta;
            do {
                System.out.print("\nDeseja remover outro cliente? (s/n): ");
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
        System.out.println("=== RELATORIO DE CLIENTES ===");
        clienteService.relatorio();
    }
}
