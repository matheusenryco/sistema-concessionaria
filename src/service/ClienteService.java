package service;

import model.Cliente;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class ClienteService {
    private final Set<Cliente> clientes = new HashSet<>();

    public void cadastrar(String nome, String telefone, String email, String rg, String cpf) {
        if (buscaPorCpf(cpf) != null) {
            throw new IllegalArgumentException("Cliente com CPF " + cpf + " ja cadastrado.");
        } else {
            Cliente cliente = new Cliente(nome, telefone, email, rg, cpf);
            clientes.add(cliente);
        }
    }

    public Cliente buscaPorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void alterarNome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ALTERAR NOME ===");
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = buscaPorCpf(cpf);

        if (cliente != null) {
            System.out.println("Cliente encontrado");
            System.out.print("Digite o novo nome: ");

            String novoNome = scanner.nextLine();
            cliente.setNome(novoNome);

            System.out.println("Nome alterado com sucesso");
        } else {
            System.out.println("Cliente nao encontrado.");
        }
    }

    public void alterarTelefone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ALTERAR TELEFONE ===");
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = buscaPorCpf(cpf);

        if (cliente != null) {
            System.out.println("Cliente encontrado");
            System.out.print("Digite o novo telefone: ");

            String novoTelefone = scanner.nextLine();
            cliente.setTelefone(novoTelefone);

            System.out.println("Telefone alterado com sucesso");
        } else {
            System.out.println("Cliente nao encontrado.");
        }
    }

    public void alterarEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ALTERAR EMAIL ===");
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = buscaPorCpf(cpf);

        if (cliente != null) {
            System.out.println("Cliente encontrado");
            System.out.print("Digite o novo email: ");

            String novoEmail = scanner.nextLine();
            cliente.setEmail(novoEmail);

            System.out.println("Email alterado com sucesso");
        } else {
            System.out.println("Cliente nao encontrado.");
        }
    }

    public void alterarRg() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ALTERAR RG ===");
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = buscaPorCpf(cpf);

        if (cliente != null) {
            System.out.println("Cliente encontrado");
            System.out.print("Digite o novo RG: ");

            String novoRg = scanner.nextLine();
            cliente.setRg(novoRg);

            System.out.println("RG alterado com sucesso");
        } else {
            System.out.println("Cliente nao encontrado.");
        }
    }

    public void alterarCpf() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ALTERAR CPF ===");
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = buscaPorCpf(cpf);

        if (cliente != null) {
            System.out.println("Cliente encontrado");
            System.out.print("Digite o novo CPF: ");

            String novoCpf = scanner.nextLine();
            cliente.setCpf(novoCpf);

            System.out.println("CPF alterado com sucesso");
        } else {
            System.out.println("Cliente nao encontrado.");
        }
    }
    
    public void remover(Cliente cliente) {
        clientes.remove(cliente);
        System.out.println("Cliente removido com sucesso"); 
    }
}