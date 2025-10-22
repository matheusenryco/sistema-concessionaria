package service;

import model.Vendas;
import model.Cliente;
import model.Funcionario;
import model.Veiculo;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class VendasService {
    private final Set<Vendas> vendas = new HashSet<>();
    private final Scanner scanner = new Scanner(System.in);
    private final ClienteService clienteService;
    private final FuncionarioService funcionarioService;
    private final VeiculoService veiculoService;

    public VendasService(ClienteService clienteService, FuncionarioService funcionarioService, VeiculoService veiculoService) {
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
        this.veiculoService = veiculoService;
    }

    public void cadastrar(String data, double valor, Cliente cliente, Funcionario funcionario, Veiculo veiculo){
        Vendas venda = new Vendas(data, valor, cliente, funcionario, veiculo);
        vendas.add(venda);
    }
    
    public Vendas consultarPorFuncionario(Funcionario funcionario) {
        for (Vendas venda : vendas) {
            if (venda.getFuncionario().equals(funcionario)) {
                return venda;
            }
        }
        return null;
    }

    public Vendas consultarPorCliente(Cliente cliente) {
        for (Vendas venda : vendas) {
            if (venda.getCliente().equals(cliente)) {
                return venda;
            }
        }
        return null;
    }

    public Vendas consultarPorVeiculo(Veiculo veiculo) {
        for (Vendas venda : vendas) {
            if (venda.getVeiculo().equals(veiculo)) {
                return venda;
            }
        }
        return null;
    }

    public void alterarData() {
        System.out.println("=== ALTERAR DATA ===");
        System.out.print("Digite o chassi do veiculo da venda: ");
        String chassi = scanner.nextLine();

        Vendas venda = buscarPorChassi(chassi);

        if (venda != null) {
            System.out.println("Venda encontrada");
            System.out.print("Digite a nova data: ");

            String novaData = scanner.nextLine();
            venda.setData(novaData);

            System.out.println("Data alterada com sucesso");
        } else {
            System.out.println("Venda nao encontrada.");
        }
    }

    public void alterarValor() {
        System.out.println("=== ALTERAR VALOR ===");
        System.out.print("Digite o chassi do veiculo da venda: ");
        String chassi = scanner.nextLine();

        Vendas venda = buscarPorChassi(chassi);

        if (venda != null) {
            System.out.println("Venda encontrada");
            System.out.print("Digite o novo valor: ");

            double novoValor = scanner.nextDouble();
            scanner.nextLine();
            venda.setValor(novoValor);

            System.out.println("Valor alterado com sucesso");
        } else {
            System.out.println("Venda nao encontrada.");
        }
    }

    public void alterarCliente() {
        System.out.println("=== ALTERAR CLIENTE ===");
        System.out.print("Digite o chassi do veiculo da venda: ");
        String chassi = scanner.nextLine();

        Vendas venda = buscarPorChassi(chassi);

        if (venda != null) {
            System.out.println("Venda encontrada");
            System.out.print("Digite o CPF do novo cliente: ");

            String cpf = scanner.nextLine();
            Cliente novoCliente = clienteService.buscaPorCpf(cpf);

            if (novoCliente != null) {
                venda.setCliente(novoCliente);
                System.out.println("Cliente alterado com sucesso");
            } else {
                System.out.println("Cliente nao encontrado.");
            }
        } else {
            System.out.println("Venda nao encontrada.");
        }
    }

    public void alterarFuncionario() {
        System.out.println("=== ALTERAR FUNCIONARIO ===");
        System.out.print("Digite o chassi do veiculo da venda: ");
        String chassi = scanner.nextLine();

        Vendas venda = buscarPorChassi(chassi);

        if (venda != null) {
            System.out.println("Venda encontrada");
            System.out.print("Digite a matricula do novo funcionario: ");

            int matricula = scanner.nextInt();
            scanner.nextLine();
            Funcionario novoFuncionario = funcionarioService.buscaPorMatricula(matricula);

            if (novoFuncionario != null) {
                venda.setFuncionario(novoFuncionario);
                System.out.println("Funcionario alterado com sucesso");
            } else {
                System.out.println("Funcionario nao encontrado.");
            }
        } else {
            System.out.println("Venda nao encontrada.");
        }
    }

    public void alterarVeiculo() {
        System.out.println("=== ALTERAR VEICULO ===");
        System.out.print("Digite o chassi do veiculo da venda atual: ");
        String chassi = scanner.nextLine();

        Vendas venda = buscarPorChassi(chassi);

        if (venda != null) {
            System.out.println("Venda encontrada");
            System.out.print("Digite o chassi do novo veiculo: ");

            String novoChassi = scanner.nextLine();
            Veiculo novoVeiculo = veiculoService.consultar(novoChassi);

            if (novoVeiculo != null) {
                venda.setVeiculo(novoVeiculo);
                System.out.println("Veiculo alterado com sucesso");
            } else {
                System.out.println("Veiculo nao encontrado.");
            }
        } else {
            System.out.println("Venda nao encontrada.");
        }
    }

    private Vendas buscarPorChassi(String chassi) {
        for (Vendas venda : vendas) {
            if (venda.getVeiculo().getChassi().equals(chassi)) {
                return venda;
            }
        }
        return null;
    }

    public boolean remover(Vendas venda) {
        return vendas.remove(venda);
    }
}
