package UI;

import java.time.Clock;
import model.Cliente;
import service.ClienteService;
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

            clienteService.cadastrar(nome, telefone, email, rg, cpf);

            System.out.println("Cliente cadastrado com sucesso!");

            System.out.print("\nDeseja continuar cadastro? (s/n): ");
            String resposta = scanner.nextLine().toLowerCase();

            if (!resposta.equals("s")) {
                continuarCadastro = false;
            }
            if (!resposta.equals("n")) {
                continuarCadastro = true;
            }
            if (!resposta.equals("s") && !resposta.equals("n")) {
                while (!resposta.equals("s") && !resposta.equals("n")) {
                    System.out.println("Resposta invalida");
                    System.out.print("\nDeseja continuar cadastro? (s/n): ");
                    resposta = scanner.nextLine().toLowerCase();
                    }
            }
        } while (continuarCadastro);

        System.out.println("Voltando ao menu principal...");
    }

    @Override
    public void consultar() {
        System.out.println("=== Consulta de Cliente ===");

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        

        Cliente cliente = clienteService.buscaPorCpf(cpf);

        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
        
    }
    
    @Override
    public void alterar() {
        boolean continuarAlteracao = true;
        int opcao;
        while(continuarAlteracao) {
            
            System.out.println("Alteracao de Cliente");
            System.out.println("O que deseja alterar: ");
            System.out.println("[1] - Nome");
            System.out.println("[2] - Telefone");
            System.out.println("[3] - Email");
            System.out.println("[4] - RG");
            System.out.println("[5] - CPF");
            System.out.println("[6] - Voltar ao menu principal");
            System.out.println("[7] - Sair");
            opcao = scanner.nextInt();
        
            switch(opcao) {
                case 1 -> clienteService.alterarNome();
                case 2 -> clienteService.alterarTelefone();
                case 3 -> clienteService.alterarEmail();
                case 4 -> clienteService.alterarRg();
                case 5 -> clienteService.alterarCpf();
                case 6 -> continuarAlteracao = false;
                case 7 -> System.exit(0);
            
        }
            
        }
        
        
        
        
        
       
    }
    
}