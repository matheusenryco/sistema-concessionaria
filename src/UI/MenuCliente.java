package UI;

import service.ClienteService;

import java.util.Scanner;

public class MenuCliente {
    private final Scanner scanner;
    private final ClienteService clienteService;

    public MenuCliente(ClienteService clienteService) {
        this.scanner = new Scanner(System.in);
        this.clienteService = clienteService;
    }
    
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

            clienteService.cadastrar(nome, telefone, email, rg, cpf);

            System.out.println("Cliente cadastrado com sucesso!");

            System.out.print("\nDeseja cadastrar outro cliente? (s/n): ");
            String resposta = scanner.nextLine().toLowerCase();

            if (!resposta.equals("s")) {
                continuarCadastro = false;
            }

        } while (continuarCadastro);

        System.out.println("Voltando ao menu principal...");
    }
}